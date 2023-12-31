package cn.devzyh.xhub.favorite.service.impl;

import cn.devzyh.xhub.common.constant.FavConstants;
import cn.devzyh.xhub.common.core.redis.RedisCache;
import cn.devzyh.xhub.favorite.domain.FavTag;
import cn.devzyh.xhub.favorite.mapper.FavTagMapper;
import cn.devzyh.xhub.favorite.service.IFavTagService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    @Autowired
    RedisCache redisCache;

    /**
     * 查询文章标签列表
     *
     * @param favTag 文章标签
     * @return 文章标签
     */
    @Override
    public List<FavTag> selectFavTagList(IPage<FavTag> page, FavTag favTag) {
        return favTagMapper.selectFavTagList(page, favTag);
    }

    /**
     * 查询文章标签
     *
     * @param id 文章标签主键
     * @return 文章标签
     */
    @Override
    public FavTag selectFavTagById(Long id) {
        return favTagMapper.selectById(id);
    }

    /**
     * 查询文章标签列表
     *
     * @param favTag 文章标签
     * @return 文章标签
     */
    @Override
    public List<FavTag> selectAllFavTag() {
        List<FavTag> tags = redisCache.getCacheObject(FavConstants.ALL_TAG_KEY);
        if (tags == null) {
            synchronized (FavTagServiceImpl.class) {
                tags = redisCache.getCacheObject(FavConstants.ALL_TAG_KEY);
                if (tags == null) {
                    tags = favTagMapper.selectFavTagList(null, new FavTag());
                    redisCache.setCacheObject(FavConstants.ALL_TAG_KEY, tags);
                }
            }
        }

        return tags;
    }


    /**
     * 新增文章标签
     *
     * @param favTag 文章标签
     * @return 结果
     */
    @Override
    public int insertFavTag(FavTag favTag) {
        redisCache.deleteObject(FavConstants.ALL_TAG_KEY);
        return favTagMapper.insert(favTag);
    }

    /**
     * 修改文章标签
     *
     * @param favTag 文章标签
     * @return 结果
     */
    @Override
    public int updateFavTag(FavTag favTag) {
        redisCache.deleteObject(FavConstants.ALL_TAG_KEY);
        return favTagMapper.updateById(favTag);
    }

    /**
     * 批量删除文章标签
     *
     * @param ids 需要删除的文章标签主键
     * @return 结果
     */
    @Override
    public int deleteFavTagByIds(List<Long> ids) {
        redisCache.deleteObject(FavConstants.ALL_TAG_KEY);
        return favTagMapper.deleteBatchIds(ids);
    }

    /**
     * 删除文章标签信息
     *
     * @param id 文章标签主键
     * @return 结果
     */
    @Override
    public int deleteFavTagById(Long id) {
        redisCache.deleteObject(FavConstants.ALL_TAG_KEY);
        return favTagMapper.deleteById(id);
    }
}
