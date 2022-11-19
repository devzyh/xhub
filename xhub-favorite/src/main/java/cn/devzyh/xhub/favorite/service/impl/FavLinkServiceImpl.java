package cn.devzyh.xhub.favorite.service.impl;

import cn.devzyh.xhub.common.constant.WebConstants;
import cn.devzyh.xhub.common.core.redis.RedisCache;
import cn.devzyh.xhub.favorite.domain.FavLink;
import cn.devzyh.xhub.favorite.mapper.FavLinkMapper;
import cn.devzyh.xhub.favorite.service.IFavLinkService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FavLinkServiceImpl implements IFavLinkService {

    @Autowired
    RedisCache redisCache;
    @Autowired
    private FavLinkMapper favLinkMapper;

    /**
     * 查询主页链接列表
     *
     * @param favLink 主页链接
     * @return 主页链接
     */
    @Override
    public List<FavLink> selectFavLinkList(IPage<FavLink> page, FavLink favLink) {
        return favLinkMapper.selectFavLinkList(page, favLink);
    }

    /**
     * 查询主页链接
     *
     * @param id 主页链接主键
     * @return 主页链接
     */
    @Override
    public FavLink selectFavLinkById(Long id) {
        return favLinkMapper.selectById(id);
    }

    /**
     * 新增主页链接
     *
     * @param favLink 主页链接
     * @return 结果
     */
    @Override
    public int insertFavLink(FavLink favLink) {
        redisCache.deleteObject(WebConstants.HOME_LINKS_KEY);
        return favLinkMapper.insert(favLink);
    }

    /**
     * 修改主页链接
     *
     * @param favLink 主页链接
     * @return 结果
     */
    @Override
    public int updateFavLink(FavLink favLink) {
        redisCache.deleteObject(WebConstants.HOME_LINKS_KEY);
        return favLinkMapper.updateById(favLink);
    }

    /**
     * 批量删除主页链接
     *
     * @param ids 需要删除的主页链接主键
     * @return 结果
     */
    @Override
    public int deleteFavLinkByIds(List<Long> ids) {
        redisCache.deleteObject(WebConstants.HOME_LINKS_KEY);
        return favLinkMapper.deleteBatchIds(ids);
    }

    /**
     * 删除主页链接信息
     *
     * @param id 主页链接主键
     * @return 结果
     */
    @Override
    public int deleteFavLinkById(Long id) {
        redisCache.deleteObject(WebConstants.HOME_LINKS_KEY);
        return favLinkMapper.deleteById(id);
    }

    @Override
    public void saveLinkVisitsToDb() {
        // 从缓存获取数据
        Map<String, Long> cacheMap = redisCache.getCacheMap(WebConstants.HOME_LINKS_VISITS_KEY);
        // 更新到数据库
        FavLink link = new FavLink();
        for (Map.Entry<String, Long> entry : cacheMap.entrySet()) {
            link.setId(Long.parseLong(entry.getKey()));
            link.setVisits(entry.getValue());
            favLinkMapper.updateById(link);
        }
    }
}
