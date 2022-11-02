package cn.devzyh.xhub.favorite.mapper;

import cn.devzyh.xhub.favorite.domain.FavTag;

import java.util.List;

/**
 * 文章标签Mapper接口
 *
 * @author devzyh
 * @date 2022-10-09
 */
public interface FavTagMapper {
    /**
     * 查询文章标签
     *
     * @param id 文章标签主键
     * @return 文章标签
     */
    public FavTag selectFavTagById(Long id);

    /**
     * 查询文章标签列表
     *
     * @param favTag 文章标签
     * @return 文章标签集合
     */
    public List<FavTag> selectFavTagList(FavTag favTag);

    /**
     * 新增文章标签
     *
     * @param favTag 文章标签
     * @return 结果
     */
    public int insertFavTag(FavTag favTag);

    /**
     * 修改文章标签
     *
     * @param favTag 文章标签
     * @return 结果
     */
    public int updateFavTag(FavTag favTag);

    /**
     * 删除文章标签
     *
     * @param id 文章标签主键
     * @return 结果
     */
    public int deleteFavTagById(Long id);

    /**
     * 批量删除文章标签
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFavTagByIds(Long[] ids);
}
