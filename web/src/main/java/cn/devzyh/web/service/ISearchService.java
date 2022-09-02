package cn.devzyh.web.service;

import cn.devzyh.web.domain.dto.SearchDto;

/**
 * 搜索服务
 */
public interface ISearchService {

    /**
     * 搜索内容
     *
     * @param key 页码
     * @param key 关键词
     * @return
     */
    SearchDto search(Integer page, String... keys);

}
