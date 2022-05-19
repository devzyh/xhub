package cn.devzyh.notebook.domain;

import cn.devzyh.common.annotation.Excel;
import cn.devzyh.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 笔记历史对象 note_history
 *
 * @author devzyh
 * @date 2022-05-18
 */
public class NoteHistory extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Long id;

    /**
     * 笔记ID
     */
    @Excel(name = "笔记ID")
    private Long contentId;

    /**
     * 标题
     */
    @Excel(name = "标题")
    private Long title;

    /**
     * 内容
     */
    @Excel(name = "内容")
    private String content;

    /**
     * 排序
     */
    @Excel(name = "排序")
    private Long rank;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }

    public Long getContentId() {
        return contentId;
    }

    public void setTitle(Long title) {
        this.title = title;
    }

    public Long getTitle() {
        return title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setRank(Long rank) {
        this.rank = rank;
    }

    public Long getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id" , getId())
                .append("contentId" , getContentId())
                .append("title" , getTitle())
                .append("content" , getContent())
                .append("rank" , getRank())
                .append("createBy" , getCreateBy())
                .append("createTime" , getCreateTime())
                .append("updateBy" , getUpdateBy())
                .append("updateTime" , getUpdateTime())
                .append("remark" , getRemark())
                .toString();
    }
}
