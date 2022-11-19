package cn.devzyh.xhub.notebook.mapper;

import cn.devzyh.xhub.notebook.domain.NoteHistory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 笔记历史Mapper接口
 *
 * @author devzyh
 * @date 2022-05-18
 */
@Mapper
public interface NoteHistoryMapper extends BaseMapper<NoteHistory> {

    /**
     * 查询笔记历史列表
     *
     * @param noteHistory 笔记历史
     * @return 笔记历史集合
     */
    List<NoteHistory> selectNoteHistoryList(IPage<NoteHistory> page, @Param("data") NoteHistory noteHistory);

}
