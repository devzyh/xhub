package cn.devzyh.favorite.domain;

import cn.devzyh.common.annotation.Excel;
import cn.devzyh.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 主页链接对象 fav_link
 *
 * @author devzyh
 * @date 2022-05-08
 */
public class FavLink extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Long id;

    /**
     * 分组
     */
    @Excel(name = "链接分组")
    private String item;

    /**
     * 名称
     */
    @Excel(name = "链接名称")
    private String name;

    /**
     * 地址
     */
    @Excel(name = "链接地址")
    private String href;

    /**
     * 图像
     */
    @Excel(name = "显示图像")
    private String icon;

    /**
     * 顺序
     */
    @Excel(name = "显示顺序")
    private Long seq;

    /**
     * $column.columnComment
     */
    @Excel(name = "打开方式")
    private String target;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getHref() {
        return href;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }

    public void setSeq(Long seq) {
        this.seq = seq;
    }

    public Long getSeq() {
        return seq;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getTarget() {
        return target;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("item", getItem())
                .append("name", getName())
                .append("href", getHref())
                .append("remark", getRemark())
                .append("icon", getIcon())
                .append("seq", getSeq())
                .append("target", getTarget())
                .toString();
    }
}
