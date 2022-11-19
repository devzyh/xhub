package cn.devzyh.xhub.notebook.domain;

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
 * 笔记分享对象 note_share
 *
 * @author devzyh
 * @date 2022-05-18
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("note_share")
public class NoteShare extends BaseEntity {

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 笔记ID
     */
    @TableId(type = IdType.AUTO)
    private Long contentId;

    /**
     * 笔记标题
     */
    @Excel(name = "笔记标题")
    @TableField(exist = false)
    private String title;

    /**
     * 访问密码
     */
    @Excel(name = "访问密码")
    private String shareSecret;

    /**
     * 分享天数
     */
    @Excel(name = "分享天数")
    private Long shareDays;

}
