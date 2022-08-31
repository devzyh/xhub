package cn.devzyh.xhub.web.service.impl;

import cn.devzyh.common.constant.WebConstants;
import cn.devzyh.common.core.redis.RedisCache;
import cn.devzyh.common.utils.DateUtils;
import cn.devzyh.common.utils.StringUtils;
import cn.devzyh.notebook.domain.NoteContent;
import cn.devzyh.notebook.domain.NoteShare;
import cn.devzyh.notebook.service.INoteContentService;
import cn.devzyh.notebook.service.INoteShareService;
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
    private RedisCache redisCache;

    @Override
    public ShareDto html(Long id, String secret, String token) {
        ShareDto dto = new ShareDto();
        NoteShare share = shareService.selectNoteShareByContentId(id);
        if (share == null) {
            dto.setError("您访问的笔记不存在");
            return dto;
        }

        NoteContent content = contentService.selectNoteContentById(id);
        // 授权码随意访问
        if (StringUtils.isNotBlank(token)) {
            // 授权码验证
            if (redisCache.getCacheObject(WebConstants.Note.TOKEN_PREFIX + token) == null) {
                dto.setError("授权码已过期");
                return dto;
            } else {
                dto.setSuccess(content);
                return dto;
            }
        }

        // 未分享的笔记
        if (share.getUpdateTime() == null) {
            dto.setError("您访问的笔记不存在");
            return dto;
        }

        // 分享到期验证
        if (share.getShareDays() > 0 && DateUtils.differentDaysByMillisecond(DateUtils.getNowDate(),
                share.getUpdateTime()) > share.getShareDays()) {
            dto.setError("您访问的笔记不存在");
            return dto;
        }

        // 访问密码验证
        if (StringUtils.isNotBlank(share.getShareSecret())) {
            if (StringUtils.isBlank(secret)) {
                dto.setSuccessWithDialog("请输入访问密码");
                return dto;
            }
            if (!StringUtils.equalsIgnoreCase(share.getShareSecret(), secret)) {
                dto.setInputSecret(secret);
                dto.setErrorWithDialog("访问密码错误");
                return dto;
            }
        }

        // 直接返回数据
        dto.setSuccess(content);
        return dto;
    }

    @Override
    public String markdown(Long id, String secret, String token) {
        ShareDto vo = html(id, secret, token);
        if (StringUtils.isNotBlank(vo.getMessage())) {
            return vo.getMessage();
        }
        return vo.getNote().getContent();
    }

}
