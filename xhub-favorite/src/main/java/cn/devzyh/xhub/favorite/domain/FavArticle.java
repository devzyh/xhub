package cn.devzyh.xhub.favorite.domain;

import cn.devzyh.xhub.common.annotation.Excel;
import cn.devzyh.xhub.common.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.List;

/**
 * 文章表 fav_article
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("fav_article")
public class FavArticle extends BaseEntity {

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
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
    private LocalDate releaseDate;

    /**
     * 关联标签ID
     */
    @TableField(exist = false)
    private List<Long> tags;

}
