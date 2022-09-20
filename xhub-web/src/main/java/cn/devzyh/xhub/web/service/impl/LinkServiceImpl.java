package cn.devzyh.xhub.web.service.impl;

import cn.devzyh.xhub.common.constant.WebConstants;
import cn.devzyh.xhub.common.core.redis.RedisCache;
import cn.devzyh.xhub.favorite.domain.FavLink;
import cn.devzyh.xhub.favorite.service.IFavLinkService;
import cn.devzyh.xhub.web.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class LinkServiceImpl implements ILinkService {

    @Autowired
    RedisCache redisCache;
    @Autowired
    private IFavLinkService favLinkService;

    @Override
    public Map<String, List<FavLink>> selectLinks() {
        Map<String, List<FavLink>> result = redisCache.getCacheMap(WebConstants.HOME_LINKS_KEY);
        if (result.isEmpty()) {
            synchronized (ILinkService.class) {
                result = redisCache.getCacheMap(WebConstants.HOME_LINKS_KEY);
                if (result.isEmpty()) {
                    // 从数据库加载
                    List<FavLink> favLinks = favLinkService.selectFavLinkList(new FavLink());
                    // 获取首页链接数据
                    result = favLinks.stream().collect(Collectors.groupingBy(FavLink::getItem));
                    Iterator<Map.Entry<String, List<FavLink>>> iterator = result.entrySet().iterator();
                    while (iterator.hasNext()) {
                        Map.Entry<String, List<FavLink>> next = iterator.next();
                        next.setValue(next.getValue().stream().limit(10).collect(Collectors.toList()));
                    }
                    redisCache.setCacheMap(WebConstants.HOME_LINKS_KEY, result);

                    // 获取首页链接访问量
                    Map<String, Long> visits = favLinks.stream().collect(Collectors
                            .toMap((k -> k.getId().toString()), (v -> v.getVisits())));
                    redisCache.setCacheMap(WebConstants.HOME_LINKS_VISITS_KEY, visits);
                }
            }
        }

        return result;
    }

    /**
     * 获取前N个友情链接数据
     *
     * @return
     */
    public List<FavLink> selectTopNFriendLinks() {
        Map<String, List<FavLink>> links = selectLinks();
        return links.get(WebConstants.LinkItem.FRIEND);
    }

    @Override
    public Map<String, Long> selectVisits() {
        return redisCache.getCacheMap(WebConstants.HOME_LINKS_VISITS_KEY);
    }

    @Override
    public void visitLink(Long id) {
        String key = id.toString();
        Long visits = redisCache.getCacheMapValue(WebConstants.HOME_LINKS_VISITS_KEY, key);
        redisCache.setCacheMapValue(WebConstants.HOME_LINKS_VISITS_KEY, key, ++visits);
    }

}
