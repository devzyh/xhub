package cn.devzyh.xhub.favorite.service.impl;

import java.util.List;

import cn.devzyh.xhub.common.core.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.devzyh.xhub.favorite.mapper.FavTagMapper;
import cn.devzyh.xhub.favorite.domain.FavTag;
import cn.devzyh.xhub.favorite.service.IFavTagService;

/**
 * 文章标签Service业务层处理
 *
 * @author devzyh
 * @date 2022-10-09
 */
@Service
public class FavTagServiceImpl implements IFavTagService {
    @Autowired
    private FavTagMapper favTagMapper;

    /**
     * 查询文章标签
     *
     * @param id 文章标签主键
     * @return 文章标签
     */
    @Override
    public FavTag selectFavTagById(Long id) {
        return favTagMapper.selectFavTagById(id);
    }

    /**
     * 查询文章标签列表
     *
     * @param favTag 文章标签
     * @return 文章标签
     */
    @Override
    public List<FavTag> selectFavTagList(FavTag favTag) {
        return favTagMapper.selectFavTagList(favTag);
    }

    /**
     * 新增文章标签
     *
     * @param favTag 文章标签
     * @return 结果
     */
    @Override
    public AjaxResult insertFavTag(FavTag favTag) {
        FavTag condition = new FavTag();
        condition.setTagCode(favTag.getTagCode());
        if (!selectFavTagList(condition).isEmpty()) {
            return AjaxResult.error("标签代码已存在");
        }
        return favTagMapper.insertFavTag(favTag) > 0 ? AjaxResult.success() : AjaxResult.error();
    }

    /**
     * 修改文章标签
     *
     * @param favTag 文章标签
     * @return 结果
     */
    @Override
    public int updateFavTag(FavTag favTag) {
        return favTagMapper.updateFavTag(favTag);
    }

    /**
     * 批量删除文章标签
     *
     * @param ids 需要删除的文章标签主键
     * @return 结果
     */
    @Override
    public int deleteFavTagByIds(Long[] ids) {
        return favTagMapper.deleteFavTagByIds(ids);
    }

    /**
     * 删除文章标签信息
     *
     * @param id 文章标签主键
     * @return 结果
     */
    @Override
    public int deleteFavTagById(Long id) {
        return favTagMapper.deleteFavTagById(id);
    }
}
