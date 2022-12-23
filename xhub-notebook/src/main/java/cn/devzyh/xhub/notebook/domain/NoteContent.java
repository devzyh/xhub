package cn.devzyh.xhub.notebook.domain;

import cn.devzyh.xhub.common.annotation.Excel;
import cn.devzyh.xhub.common.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 笔记内容对象 note_content
 *
 * @author devzyh
 * @date 2022-05-18
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("note_content")
public class NoteContent extends BaseEntity {

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 目录
     */
    @Excel(name = "目录")
    private Long catalogId;

    /**
     * 标题
     */
    @Excel(name = "标题")
    private String title;

    /**
     * 内容
     */
    @Excel(name = "内容")
    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private String content;

    /**
     * 排序
     */
    @Excel(name = "排序")
    private Long rank;

    /**
     * 删除标记
     */
    @Excel(name = "删除标记")
    private Integer delFlag;

}
