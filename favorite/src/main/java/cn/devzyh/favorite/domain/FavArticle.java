package cn.devzyh.favorite.domain;

import cn.devzyh.common.annotation.Excel;
import cn.devzyh.common.core.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.time.LocalDate;
import java.util.List;

/**
 * 文章表 fav_article
 */
public class FavArticle extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Long id;

    /**
     * 标题
     */
    @Excel(name = "文章标题")
    private String title;

    /**
     * 地址
     */
    @Excel(name = "文章地址")
    private String url;

    /**
     * 内容摘要
     */
    @Excel(name = "内容摘要")
    private String digest;

    /**
     * 来源平台
     */
    @Excel(name = "来源平台")
    private String source;

    /**
     * 发布日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发布日期", width = 30, dateFormat = "yyyy-MM-dd")
    private LocalDate created;

    /**
     * 关联标签
     */
    private String tags;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public String getDigest() {
        return digest;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSource() {
        return source;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public LocalDate getCreated() {
        return created;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("title", getTitle())
                .append("url", getUrl())
                .append("digest", getDigest())
                .append("source", getSource())
                .append("created", getCreated())
                .toString();
    }
}
