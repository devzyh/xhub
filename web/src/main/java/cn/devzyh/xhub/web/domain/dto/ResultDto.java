package cn.devzyh.xhub.web.domain.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * 搜索结果数据类
 */
public class ResultDto implements Serializable {

    private static final long serialVersionUID = -3853080211929027381L;
    private String title; // 标题
    private String url; // 地址
    private LocalDate postDate; // 发布日期
    private String digest; // 摘要
    private String image; // 图形
    private String source; // 来源
    private List<String> tags; // 标签列表

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

    public LocalDate getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDate postDate) {
        this.postDate = postDate;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
