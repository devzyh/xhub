package cn.devzyh.toolbox.service.impl;

import cn.devzyh.common.constant.ToolConstants;
import cn.devzyh.common.core.domain.entity.SysDictData;
import cn.devzyh.toolbox.mapper.ToolDictDataMapper;
import cn.devzyh.toolbox.service.IToolDictDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class ToolDictDataServiceImpl implements IToolDictDataService {

    @Autowired
    private ToolDictDataMapper dictDataMapper;

    @Override
    public Map<String, String> getConfigMapByItem(ToolConstants.Item item) {
        Map<String, String> map = new HashMap<>();
        List<SysDictData> details = dictDataMapper.selectDictDataByType(item.getValue());
        details.forEach(detail -> {
            map.put(detail.getDictValue(), detail.getDictLabel());
        });
        return map;
    }

    @Override
    public Map<String, String> getSiteInfo() {
        return getConfigMapByItem(ToolConstants.Item.SITE_INFO);
    }

}
