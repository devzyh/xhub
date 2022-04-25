package cn.devzyh.toolbox.service.impl;

import cn.devzyh.common.constant.ToolConstants;
import cn.devzyh.toolbox.domain.Config;
import cn.devzyh.toolbox.mapper.ConfigMapper;
import cn.devzyh.toolbox.service.IConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class ConfigServiceImpl implements IConfigService {

    @Autowired
    private ConfigMapper configMapper;

    @Override
    public Map<String, String> getConfigMapByItem(ToolConstants.Item item) {
        Map<String, String> map = new HashMap<>();
        List<Config> details = configMapper.findByItem(item.getValue());
        details.forEach(detail -> {
            map.put(detail.getName(), detail.getValue());
        });
        return map;
    }

    @Override
    public Map<String, String> getSiteInfo() {
        return getConfigMapByItem(ToolConstants.Item.SITE_INFO);
    }

}
