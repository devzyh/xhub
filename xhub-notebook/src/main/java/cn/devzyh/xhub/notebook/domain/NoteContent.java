package cn.devzyh.xhub.notebook.domain;

import cn.devzyh.xhub.common.annotation.Excel;
import cn.devzyh.xhub.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 笔记内容对象 note_content
 *
 * @author devzyh
 * @date 2022-05-18
 */
public class NoteContent extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Long id;

    /**
     * 目录
     */
    @Excel(name = "目录")
    private Long catalogId;

    /**
     * 标题
     */
    @Excel(name = "标题")
    private String title;

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

    /**
     * 删除标记
     */
    @Excel(name = "删除标记")
    private Integer deleteFlag;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setCatalogId(Long catalogId) {
        this.catalogId = catalogId;
    }

    public Long getCatalogId() {
        return catalogId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
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

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("catalogId", getCatalogId())
                .append("title", getTitle())
                .append("content", getContent())
                .append("rank", getRank())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .append("deleteFlag", getDeleteFlag())
                .toString();
    }
}
