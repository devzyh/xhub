package cn.devzyh.toolbox.service.impl;

import cn.devzyh.toolbox.domain.ToolFavorite;
import cn.devzyh.toolbox.mapper.ToolFavoriteMapper;
import cn.devzyh.toolbox.service.IToolFavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class ToolFavoriteServiceImpl implements IToolFavoriteService {

    @Autowired
    private ToolFavoriteMapper toolFavoriteMapper;

    @Override
    public Map<String, List<ToolFavorite>> getFavorites() {
        Map<String, List<ToolFavorite>> result = new HashMap<>();
        List<ToolFavorite> toolFavorites = toolFavoriteMapper.findAll();
        toolFavorites.forEach(toolFavorite -> {
            List<ToolFavorite> list = result.get(toolFavorite.getItem());
            if (list == null) {
                list = new LinkedList<>();
            }

            list.add(toolFavorite);
            result.put(toolFavorite.getItem(), list);
        });

        return result;
    }
}
