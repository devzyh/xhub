package cn.devzyh.toolbox.service;

import cn.devzyh.toolbox.domain.vo.SearchVO;

/**
 * 搜索服务
 */
public interface ISearchService {

    /**
     * 搜索内容
     *
     * @param key 关键词
     * @return
     */
    SearchVO search(String key);
}
