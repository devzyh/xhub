package cn.devzyh.xhub.notebook.mapper;

import cn.devzyh.xhub.notebook.domain.NoteCatalog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 笔记目录Mapper接口
 *
 * @author devzyh
 * @date 2022-05-18
 */
@Mapper
public interface NoteCatalogMapper extends BaseMapper<NoteCatalog> {

    /**
     * 查询笔记目录列表
     *
     * @param noteCatalog 笔记目录
     * @return 笔记目录集合
     */
    List<NoteCatalog> selectNoteCatalogList(NoteCatalog noteCatalog);

}
