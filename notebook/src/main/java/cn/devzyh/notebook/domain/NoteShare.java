package cn.devzyh.notebook.domain;

import cn.devzyh.common.annotation.Excel;
import cn.devzyh.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 笔记分享对象 note_share
 *
 * @author devzyh
 * @date 2022-05-18
 */
public class NoteShare extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 笔记ID
     */
    private Long contentId;

    /**
     * 访问密码
     */
    @Excel(name = "访问密码")
    private String shareSecret;

    /**
     * 分享天数
     */
    @Excel(name = "分享天数")
    private Long shareDays;

    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }

    public Long getContentId() {
        return contentId;
    }

    public void setShareSecret(String shareSecret) {
        this.shareSecret = shareSecret;
    }

    public String getShareSecret() {
        return shareSecret;
    }

    public void setShareDays(Long shareDays) {
        this.shareDays = shareDays;
    }

    public Long getShareDays() {
        return shareDays;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("contentId" , getContentId())
                .append("shareSecret" , getShareSecret())
                .append("shareDays" , getShareDays())
                .append("createBy" , getCreateBy())
                .append("createTime" , getCreateTime())
                .append("updateBy" , getUpdateBy())
                .append("updateTime" , getUpdateTime())
                .append("remark" , getRemark())
                .toString();
    }
}
