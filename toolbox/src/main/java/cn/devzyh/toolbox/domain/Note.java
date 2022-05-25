package cn.devzyh.toolbox.domain;

import cn.devzyh.common.core.domain.BaseEntity;

import java.time.LocalDateTime;

/**
 * 笔记表
 */
public class Note extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Long id;

    /**
     * 笔记标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 排序
     */
    private Long rank;

    /**
     * 删除标记
     */
    private Integer deleteFlag;

    /**
     * 访问密码
     */
    private String shareSecret;

    /**
     * 分享天数
     */
    private Long shareDays;

    /**
     * 分享时间
     */
    private LocalDateTime shareUpdateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getRank() {
        return rank;
    }

    public void setRank(Long rank) {
        this.rank = rank;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getShareSecret() {
        return shareSecret;
    }

    public void setShareSecret(String shareSecret) {
        this.shareSecret = shareSecret;
    }

    public Long getShareDays() {
        return shareDays;
    }

    public void setShareDays(Long shareDays) {
        this.shareDays = shareDays;
    }

    public LocalDateTime getShareUpdateTime() {
        return shareUpdateTime;
    }

    public void setShareUpdateTime(LocalDateTime shareUpdateTime) {
        this.shareUpdateTime = shareUpdateTime;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", rank=" + rank +
                ", deleteFlag=" + deleteFlag +
                ", shareSecret='" + shareSecret + '\'' +
                ", shareDays=" + shareDays +
                ", shareUpdateTime=" + shareUpdateTime +
                '}';
    }
}
