package cn.devzyh.xhub.notebook.controller;

import cn.devzyh.xhub.common.annotation.Log;
import cn.devzyh.xhub.common.constant.WebConstants;
import cn.devzyh.xhub.common.core.controller.BaseController;
import cn.devzyh.xhub.common.core.domain.Result;
import cn.devzyh.xhub.common.core.page.PageResult;
import cn.devzyh.xhub.common.core.redis.RedisCache;
import cn.devzyh.xhub.common.enums.BusinessType;
import cn.devzyh.xhub.common.utils.SecurityUtils;
import cn.devzyh.xhub.common.utils.poi.ExcelUtil;
import cn.devzyh.xhub.notebook.domain.NoteContent;
import cn.devzyh.xhub.notebook.service.INoteContentService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 笔记内容Controller
 *
 * @author devzyh
 * @date 2022-05-18
 */
@RestController
@RequestMapping("/rest/notebook/content")
public class NoteContentController extends BaseController {

    @Autowired
    private INoteContentService contentService;
    @Autowired
    private RedisCache redisCache;

    /**
     * 查询笔记内容列表
     */
    @PreAuthorize("@ss.hasPermi('notebook:content:list')")
    @GetMapping("/list")
    public PageResult list(NoteContent noteContent) {
        IPage<NoteContent> page = getPage();
        return getPageResult(page, contentService.selectNoteContentList(page, noteContent));
    }

    /**
     * 导出笔记内容列表
     */
    @PreAuthorize("@ss.hasPermi('notebook:content:export')")
    @Log(title = "笔记内容", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, NoteContent noteContent) {
        List<NoteContent> list = contentService.selectNoteContentList(null, noteContent);
        ExcelUtil<NoteContent> util = new ExcelUtil<NoteContent>(NoteContent.class);
        util.exportExcel(response, list, "笔记内容数据");
    }

    /**
     * 获取笔记内容详细信息
     */
    @PreAuthorize("@ss.hasPermi('notebook:content:query')")
    @GetMapping(value = "/{id}")
    public Result getInfo(@PathVariable("id") Long id) {
        NoteContent content = contentService.selectNoteContentById(id);
        if (content==null||!content.getCreateBy().equals(SecurityUtils.getUserName())) {
            return Result.error("权限错误");
        }

        return Result.success(content);
    }

    /**
     * 新增笔记内容
     */
    @PreAuthorize("@ss.hasPermi('notebook:content:add')")
    @Log(title = "笔记内容", businessType = BusinessType.INSERT)
    @PostMapping
    public Result add(@RequestBody NoteContent noteContent) {
        return toResult(contentService.insertNoteContent(noteContent));
    }

    /**
     * 修改基本信息
     */
    @PreAuthorize("@ss.hasPermi('notebook:content:edit')")
    @Log(title = "笔记基本信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public Result edit(@RequestBody NoteContent noteContent) {
        return contentService.updateNoteContent(noteContent, false);
    }

    /**
     * 修改笔记内容
     */
    @PreAuthorize("@ss.hasPermi('notebook:content:edit')")
    @Log(title = "笔记编辑内容", businessType = BusinessType.UPDATE)
    @PutMapping("/editor")
    public Result editContent(@RequestBody NoteContent noteContent) {
        return contentService.updateNoteContent(noteContent, true);
    }

    /**
     * 更新内容缓存
     */
    @PreAuthorize("@ss.hasPermi('notebook:content:edit')")
    @Log(title = "笔记编辑内容", businessType = BusinessType.UPDATE)
    @PutMapping("/cache")
    public Result cache(@RequestBody NoteContent noteContent) {
        return contentService.updateNoteCache(noteContent);
    }

    /**
     * 删除笔记内容
     */
    @PreAuthorize("@ss.hasPermi('notebook:content:remove')")
    @Log(title = "笔记内容", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public Result remove(@PathVariable List<Long> ids) {
        return toResult(contentService.deleteNoteContentByIds(ids));
    }

    /**
     * 生成访问Token
     */
    @PreAuthorize("@ss.hasPermi('notebook:content:token')")
    @Log(title = "笔记内容", businessType = BusinessType.OTHER)
    @GetMapping("/generateToken")
    public Result generateToken() {
        String token = UUID.randomUUID().toString();
        redisCache.setCacheObject(WebConstants.Note.TOKEN_PREFIX + token, token,
                WebConstants.Note.TOKEN_EXPIRE, TimeUnit.MINUTES);
        return Result.success(null, token);
    }

    /**
     * 导入笔记内容列表
     */
    @PreAuthorize("@ss.hasPermi('notebook:content:import')")
    @Log(title = "笔记内容", businessType = BusinessType.IMPORT)
    @PostMapping("/import/{catalogId}")
    public Result importContent(@PathVariable Long catalogId, @RequestParam(required = true) MultipartFile file) {
        try {
            NoteContent content = new NoteContent();
            content.setCatalogId(catalogId);
            String title = file.getOriginalFilename();
            title = title.replace(title.substring(title.lastIndexOf(".")), "");
            content.setTitle(title);
            content.setContent(new String(file.getBytes()));
            return toResult(contentService.insertNoteContent(content));
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }
}
