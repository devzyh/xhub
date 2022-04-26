package cn.devzyh.toolbox.service;

import cn.devzyh.toolbox.domain.ToolFavorite;

import java.util.List;
import java.util.Map;

/**
 * 收藏夹服务层
 */
public interface IToolFavoriteService {

    /**
     * 获取分组及工具详情
     *
     * @return
     */
    Map<String, List<ToolFavorite>> getFavorites();

}
