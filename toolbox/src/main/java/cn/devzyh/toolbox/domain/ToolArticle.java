package cn.devzyh.toolbox.domain;

import java.time.LocalDate;
import java.util.List;

/**
 * 文章表
 */
public class ToolArticle {

    private Integer id; // ID
    private String title; // 标题
    private String url; // 地址
    private String digest; // 摘要
    private String source; // 来源平台
    private LocalDate created; // 发布时间
    private List<String> tags; // 所属标签

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
