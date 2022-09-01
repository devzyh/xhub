package cn.devzyh.web.service.impl;

import cn.devzyh.common.constant.WebConstants;
import cn.devzyh.favorite.domain.FavLink;
import cn.devzyh.favorite.service.IFavLinkService;
import cn.devzyh.web.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class LinkServiceImpl implements ILinkService {

    @Autowired
    private IFavLinkService favLinkService;

    @Override
    public Map<String, List<FavLink>> selectLinks() {
        Map<String, List<FavLink>> result = new HashMap<>();
        List<FavLink> favLinks = favLinkService.selectFavLinkList(new FavLink());
        favLinks.forEach(toolFavorite -> {
            List<FavLink> list = result.get(toolFavorite.getItem());
            if (list == null) {
                list = new LinkedList<>();
            }

            // 首页每组展示链接限制
            if (list.size() < WebConstants.Home.SHOW_ITEM_LIMIT) {
                list.add(toolFavorite);
                result.put(toolFavorite.getItem(), list);
            }
        });

        return result;
    }

}
