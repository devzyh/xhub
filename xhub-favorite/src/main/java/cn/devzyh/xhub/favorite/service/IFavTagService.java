package cn.devzyh.xhub.favorite.service;

import cn.devzyh.xhub.favorite.domain.FavTag;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * 文章标签Service接口
 *
 * @author devzyh
 * @date 2022-10-09
 */
public interface IFavTagService {

    /**
     * 查询文章标签列表
     *
     * @param favTag 文章标签
     * @return 文章标签集合
     */
    List<FavTag> selectFavTagList(IPage<FavTag> page, FavTag favTag);

    /**
     * 查询文章标签
     *
     * @param id 文章标签主键
     * @return 文章标签
     */
    FavTag selectFavTagById(Long id);

    /**
     * 查询所有文章标签
     *
     * @param favTag 文章标签
     * @return 文章标签集合
     */
    List<FavTag> selectAllFavTag();

    /**
     * 新增文章标签
     *
     * @param favTag 文章标签
     * @return 结果
     */
    int insertFavTag(FavTag favTag);

    /**
     * 修改文章标签
     *
     * @param favTag 文章标签
     * @return 结果
     */
    int updateFavTag(FavTag favTag);

    /**
     * 批量删除文章标签
     *
     * @param ids 需要删除的文章标签主键集合
     * @return 结果
     */
    int deleteFavTagByIds(List<Long> ids);

    /**
     * 删除文章标签信息
     *
     * @param id 文章标签主键
     * @return 结果
     */
    int deleteFavTagById(Long id);
}
