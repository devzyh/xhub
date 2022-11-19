package cn.devzyh.xhub.notebook.domain;

import cn.devzyh.xhub.common.annotation.Excel;
import cn.devzyh.xhub.common.core.domain.TreeEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 笔记目录对象 note_catalog
 *
 * @author devzyh
 * @date 2022-05-18
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("note_catalog")
public class NoteCatalog extends TreeEntity {

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 名称
     */
    @Excel(name = "名称")
    private String name;

    /**
     * 排序
     */
    @Excel(name = "排序")
    private Long rank;

    /**
     * 删除标记
     */
    @Excel(name = "删除标记")
    @TableLogic(value = "0", delval = "2")
    private Integer deleteFlag;

}
