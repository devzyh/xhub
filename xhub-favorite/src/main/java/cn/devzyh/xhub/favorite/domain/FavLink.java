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
 * 主页链接对象 fav_link
 *
 * @author devzyh
 * @date 2022-05-08
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("fav_link")
public class FavLink extends BaseEntity {

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
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
     * 打开方式
     */
    @Excel(name = "打开方式")
    private String target;

    /**
     * 访问次数
     */
    @Excel(name = "访问次数")
    private Long visits;

}
