package cn.devzyh.xhub.favorite.mapper;

import cn.devzyh.xhub.favorite.domain.FavTag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 文章标签Mapper接口
 *
 * @author devzyh
 * @date 2022-10-09
 */
@Mapper
public interface FavTagMapper extends BaseMapper<FavTag> {

    /**
     * 查询文章标签列表
     *
     * @param favTag 文章标签
     * @return 文章标签集合
     */
    List<FavTag> selectFavTagList(IPage<FavTag> page, @Param("data") FavTag favTag);

}
