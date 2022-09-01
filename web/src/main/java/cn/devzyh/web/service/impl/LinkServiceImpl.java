package cn.devzyh.web.service.impl;

import cn.devzyh.common.constant.WebConstants;
import cn.devzyh.common.core.redis.RedisCache;
import cn.devzyh.favorite.domain.FavLink;
import cn.devzyh.favorite.service.IFavLinkService;
import cn.devzyh.web.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class LinkServiceImpl implements ILinkService {

    @Autowired
    RedisCache redisCache;
    @Autowired
    private IFavLinkService favLinkService;

    @Override
    public Map<String, List<FavLink>> selectLinks() {
        Map<String, List<FavLink>> result = redisCache.getCacheMap(WebConstants.WEB_HOME_LINKS_KEY);
        if (result.isEmpty()) {
            synchronized (ILinkService.class) {
                result = redisCache.getCacheMap(WebConstants.WEB_HOME_LINKS_KEY);
                if (result.isEmpty()) {
                    // 从数据库加载
                    List<FavLink> favLinks = favLinkService.selectFavLinkList(new FavLink());
                    result = favLinks.stream().collect(Collectors.groupingBy(FavLink::getItem));
                    Iterator<Map.Entry<String, List<FavLink>>> iterator = result.entrySet().iterator();
                    while (iterator.hasNext()) {
                        Map.Entry<String, List<FavLink>> next = iterator.next();
                        next.setValue(next.getValue().stream().limit(10).collect(Collectors.toList()));
                    }
                    redisCache.setCacheMap(WebConstants.WEB_HOME_LINKS_KEY, result);
                }
            }
        }

        return result;
    }

}
