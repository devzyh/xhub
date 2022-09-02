package cn.devzyh.web.service;


import cn.devzyh.favorite.domain.FavLink;

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

    /**
     * 获取连接访问次数
     *
     * @return
     */
    Map<String, Long> selectVisits();

    /**
     * 统计访问首页次数
     *
     * @param id
     */
    void visitLink(Long id);

}
