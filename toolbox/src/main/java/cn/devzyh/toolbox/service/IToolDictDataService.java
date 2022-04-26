package cn.devzyh.toolbox.service;

import cn.devzyh.common.constant.ToolConstants;

import java.util.Map;

public interface IToolDictDataService {

    /**
     * 获取指定分组对照表
     *
     * @return
     */
    Map<String, String> getConfigMapByItem(ToolConstants.Item item);


    /**
     * 获取站点信息
     *
     * @return
     */
    Map<String, String> getSiteInfo();

}
