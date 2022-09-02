package cn.devzyh.favorite.service.impl;

import cn.devzyh.common.constant.WebConstants;
import cn.devzyh.common.core.redis.RedisCache;
import cn.devzyh.favorite.domain.FavLink;
import cn.devzyh.favorite.mapper.FavLinkMapper;
import cn.devzyh.favorite.service.IFavLinkService;
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
     * 查询主页链接
     *
     * @param id 主页链接主键
     * @return 主页链接
     */
    @Override
    public FavLink selectFavLinkById(Long id) {
        return favLinkMapper.selectFavLinkById(id);
    }

    /**
     * 查询主页链接列表
     *
     * @param favLink 主页链接
     * @return 主页链接
     */
    @Override
    public List<FavLink> selectFavLinkList(FavLink favLink) {
        return favLinkMapper.selectFavLinkList(favLink);
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
        return favLinkMapper.insertFavLink(favLink);
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
        return favLinkMapper.updateFavLink(favLink);
    }

    /**
     * 批量删除主页链接
     *
     * @param ids 需要删除的主页链接主键
     * @return 结果
     */
    @Override
    public int deleteFavLinkByIds(Long[] ids) {
        redisCache.deleteObject(WebConstants.HOME_LINKS_KEY);
        return favLinkMapper.deleteFavLinkByIds(ids);
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
        return favLinkMapper.deleteFavLinkById(id);
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
            favLinkMapper.updateFavLink(link);
        }
    }
}
