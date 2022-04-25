package cn.devzyh.toolbox.service;

import cn.devzyh.toolbox.domain.Favorite;

import java.util.List;
import java.util.Map;

/**
 * 收藏夹服务层
 */
public interface IFavoriteService {

    /**
     * 获取分组及工具详情
     *
     * @return
     */
    Map<String, List<Favorite>> getFavorites();
}
