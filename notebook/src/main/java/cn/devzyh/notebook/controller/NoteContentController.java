package cn.devzyh.notebook.controller;

import cn.devzyh.common.annotation.Log;
import cn.devzyh.common.constant.WebConstants;
import cn.devzyh.common.core.controller.BaseController;
import cn.devzyh.common.core.domain.AjaxResult;
import cn.devzyh.common.core.page.TableDataInfo;
import cn.devzyh.common.core.redis.RedisCache;
import cn.devzyh.common.enums.BusinessType;
import cn.devzyh.common.utils.poi.ExcelUtil;
import cn.devzyh.notebook.domain.NoteContent;
import cn.devzyh.notebook.service.INoteContentService;
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
    public TableDataInfo list(NoteContent noteContent) {
        startPage();
        List<NoteContent> list = contentService.selectNoteContentList(noteContent);
        return getDataTable(list);
    }

    /**
     * 导出笔记内容列表
     */
    @PreAuthorize("@ss.hasPermi('notebook:content:export')")
    @Log(title = "笔记内容", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, NoteContent noteContent) {
        List<NoteContent> list = contentService.selectNoteContentList(noteContent);
        ExcelUtil<NoteContent> util = new ExcelUtil<NoteContent>(NoteContent.class);
        util.exportExcel(response, list, "笔记内容数据");
    }

    /**
     * 获取笔记内容详细信息
     */
    @PreAuthorize("@ss.hasPermi('notebook:content:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(contentService.selectNoteContentById(id));
    }

    /**
     * 新增笔记内容
     */
    @PreAuthorize("@ss.hasPermi('notebook:content:add')")
    @Log(title = "笔记内容", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody NoteContent noteContent) {
        return toAjax(contentService.insertNoteContent(noteContent));
    }

    /**
     * 修改笔记内容
     */
    @PreAuthorize("@ss.hasPermi('notebook:content:edit')")
    @Log(title = "笔记内容", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody NoteContent noteContent) {
        return toAjax(contentService.updateNoteContent(noteContent));
    }

    /**
     * 删除笔记内容
     */
    @PreAuthorize("@ss.hasPermi('notebook:content:remove')")
    @Log(title = "笔记内容", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(contentService.deleteNoteContentByIds(ids));
    }

    /**
     * 生成访问Token
     */
    @PreAuthorize("@ss.hasPermi('notebook:content:token')")
    @Log(title = "笔记内容", businessType = BusinessType.OTHER)
    @GetMapping("/generateToken")
    public AjaxResult generateToken() {
        String token = UUID.randomUUID().toString();
        redisCache.setCacheObject(WebConstants.Note.TOKEN_PREFIX + token, token,
                WebConstants.Note.TOKEN_EXPIRE, TimeUnit.MINUTES);
        return AjaxResult.success(null, token);
    }

    /**
     * 导入笔记内容列表
     */
    @PreAuthorize("@ss.hasPermi('notebook:content:import')")
    @Log(title = "笔记内容", businessType = BusinessType.IMPORT)
    @PostMapping("/import/{catalogId}")
    public AjaxResult importContent(@PathVariable Long catalogId, @RequestParam(required = true) MultipartFile file) {
        try {
            NoteContent content = new NoteContent();
            content.setCatalogId(catalogId);
            String title = file.getOriginalFilename();
            title = title.replace(title.substring(title.lastIndexOf(".")), "");
            content.setTitle(title);
            content.setContent(new String(file.getBytes()));
            return toAjax(contentService.insertNoteContent(content));
        } catch (Exception e) {
            return AjaxResult.error(e.getMessage());
        }
    }
}
