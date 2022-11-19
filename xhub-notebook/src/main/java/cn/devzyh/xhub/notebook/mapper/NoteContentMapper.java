package cn.devzyh.xhub.notebook.mapper;

import cn.devzyh.xhub.notebook.domain.NoteContent;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 笔记内容Mapper接口
 *
 * @author devzyh
 * @date 2022-05-18
 */
@Mapper
public interface NoteContentMapper extends BaseMapper<NoteContent> {

    /**
     * 查询笔记内容列表
     *
     * @param noteContent 笔记内容
     * @return 笔记内容集合
     */
    List<NoteContent> selectNoteContentList(IPage<NoteContent> page, @Param("data") NoteContent noteContent);

}
