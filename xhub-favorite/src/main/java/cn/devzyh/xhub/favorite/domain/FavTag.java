package cn.devzyh.xhub.favorite.domain;

import cn.devzyh.xhub.common.annotation.Excel;
import cn.devzyh.xhub.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 文章标签对象 fav_tag
 *
 * @author devzyh
 * @date 2022-10-09
 */
public class FavTag extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Long id;

    /**
     * 标签代码
     */
    @Excel(name = "标签代码")
    private String tagCode;

    /**
     * 标签名称
     */
    @Excel(name = "标签名称")
    private String tagName;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setTagCode(String tagCode) {
        this.tagCode = tagCode;
    }

    public String getTagCode() {
        return tagCode;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getTagName() {
        return tagName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("tagCode", getTagCode())
                .append("tagName", getTagName())
                .toString();
    }
}
