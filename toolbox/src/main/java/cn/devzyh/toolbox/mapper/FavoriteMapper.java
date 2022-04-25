package cn.devzyh.toolbox.mapper;

import cn.devzyh.toolbox.domain.Article;
import cn.devzyh.toolbox.domain.Favorite;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FavoriteMapper {

    /**
     * 查询所有工具
     *
     * @return 收藏列表
     */
    List<Favorite> findAll();

    /**
     * 模糊搜索标题
     *
     * @param key 关键字
     * @return
     */
    List<Favorite> search(@Param("key") String key);
}
