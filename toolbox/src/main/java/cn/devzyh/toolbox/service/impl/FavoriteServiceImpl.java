package cn.devzyh.toolbox.service.impl;

import cn.devzyh.toolbox.domain.Favorite;
import cn.devzyh.toolbox.mapper.FavoriteMapper;
import cn.devzyh.toolbox.service.IFavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class FavoriteServiceImpl implements IFavoriteService {

    @Autowired
    private FavoriteMapper favoriteMapper;

    @Override
    public Map<String, List<Favorite>> getFavorites() {
        Map<String, List<Favorite>> result = new HashMap<>();
        List<Favorite> favorites = favoriteMapper.findAll();
        favorites.forEach(favorite -> {
            List<Favorite> list = result.get(favorite.getItem());
            if (list == null) {
                list = new LinkedList<>();
            }

            list.add(favorite);
            result.put(favorite.getItem(), list);
        });

        return result;
    }
}
