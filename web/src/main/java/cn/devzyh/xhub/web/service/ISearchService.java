package cn.devzyh.xhub.web.service;

import cn.devzyh.xhub.web.domain.dto.SearchDto;

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
    SearchDto search(String... keys);

}
