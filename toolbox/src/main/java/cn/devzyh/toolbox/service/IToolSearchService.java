package cn.devzyh.toolbox.service;

import cn.devzyh.toolbox.domain.vo.SearchVo;

/**
 * 搜索服务
 */
public interface IToolSearchService {

    /**
     * 搜索内容
     *
     * @param key 关键词
     * @return
     */
    SearchVo search(String key);

}
