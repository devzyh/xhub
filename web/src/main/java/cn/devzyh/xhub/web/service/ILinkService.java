package cn.devzyh.xhub.web.service;


import cn.devzyh.xhub.favorite.domain.dao.FavLink;

import java.util.List;
import java.util.Map;

/**
 * 收藏夹服务层
 */
public interface ILinkService {

    /**
     * 获取分组及工具详情
     *
     * @return
     */
    Map<String, List<FavLink>> selectLinks();

}
