package cn.devzyh.xhub.favorite.domain;

import cn.devzyh.xhub.common.annotation.Excel;
import cn.devzyh.xhub.common.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 文章标签对象 fav_tag
 *
 * @author devzyh
 * @date 2022-10-09
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("fav_tag")
public class FavTag extends BaseEntity {

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 标签名称
     */
    @Excel(name = "标签名称")
    private String name;

}
