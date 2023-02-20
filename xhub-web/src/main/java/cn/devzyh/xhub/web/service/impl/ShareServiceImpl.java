package cn.devzyh.xhub.web.service.impl;

import cn.devzyh.xhub.common.constant.WebConstants;
import cn.devzyh.xhub.common.core.domain.entity.SysUser;
import cn.devzyh.xhub.common.core.redis.RedisCache;
import cn.devzyh.xhub.common.utils.DateUtils;
import cn.devzyh.xhub.common.utils.StringUtils;
import cn.devzyh.xhub.framework.service.ISysUserService;
import cn.devzyh.xhub.notebook.domain.NoteContent;
import cn.devzyh.xhub.notebook.domain.NoteShare;
import cn.devzyh.xhub.notebook.service.INoteContentService;
import cn.devzyh.xhub.notebook.service.INoteShareService;
import cn.devzyh.xhub.web.domain.dto.ShareDto;
import cn.devzyh.xhub.web.service.IShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShareServiceImpl implements IShareService {

    @Autowired
    private INoteShareService shareService;
    @Autowired
    private INoteContentService contentService;
    @Autowired
    private ISysUserService userService;
    @Autowired
    private RedisCache redisCache;

    @Override
    public ShareDto html(Long id, String secret) {
        NoteContent content = contentService.selectNoteContentById(id);
        if (content == null) {
            return ShareDto.error("您访问的笔记不存在！");
        }

        // 数据转换
        SysUser user = userService.selectUserByUserName(content.getCreateBy());
        if (user != null) {
            content.setCreateBy(user.getNickName());
        }

        // 授权码访问验证
        if (StringUtils.isNotBlank(secret) &&
                redisCache.getCacheObject(WebConstants.Note.TOKEN_PREFIX + secret) != null) {
            return ShareDto.success(content);
        }

        // 前台分享访问
        NoteShare share = shareService.selectNoteShareByContentId(id);
        if (share == null) {
            return ShareDto.error("您访问的笔记不存在！");
        }

        // 前台分享过期
        if (share.getShareDays() > 0 && DateUtils.differentDaysByMillisecond(DateUtils.getNowDate(),
                share.getUpdateTime()) > share.getShareDays()) {
            return ShareDto.error("您访问的笔记不存在！");
        }

        // 前台密码访问
        if (StringUtils.isNotBlank(share.getShareSecret())) {
            if (StringUtils.isBlank(secret)) {
                return ShareDto.errorWithInput("请输入访问密码！");
            }
            if (!StringUtils.equalsIgnoreCase(share.getShareSecret(), secret)) {
                return ShareDto.errorWithInput("输入的访问密码错误！", secret);
            }
        }

        // 直接返回数据
        return ShareDto.success(content);
    }

    @Override
    public String markdown(Long id, String secret) {
        ShareDto dto = html(id, secret);
        if (dto.isSuccess()) {
            return dto.getNote().getContent();
        } else {
            return dto.getMessage();
        }
    }

}
