package cn.devzyh.xhub.notebook.mapper;

import cn.devzyh.xhub.notebook.domain.NoteShare;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 笔记分享Mapper接口
 *
 * @author devzyh
 * @date 2022-05-18
 */
@Mapper
public interface NoteShareMapper extends BaseMapper<NoteShare> {

    /**
     * 查询笔记分享列表
     *
     * @param noteShare 笔记分享
     * @return 笔记分享集合
     */
    List<NoteShare> selectNoteShareList(IPage<NoteShare> page, @Param("data") NoteShare noteShare);

    /**
     * 查询笔记分享
     *
     * @param contentId 笔记分享主键
     * @return 笔记分享
     */
    NoteShare selectNoteShareByContentId(Long contentId);

}
