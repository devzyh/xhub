package cn.devzyh.toolbox.mapper;

import cn.devzyh.toolbox.domain.ToolFavorite;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ToolFavoriteMapper {

    /**
     * 查询所有工具
     *
     * @return 收藏列表
     */
    List<ToolFavorite> findAll();

    /**
     * 模糊搜索标题
     *
     * @param key 关键字
     * @return
     */
    List<ToolFavorite> search(@Param("key") String key);
}
