package cn.devzyh.xhub.web.utils;

import cn.devzyh.common.constant.WebConstants;
import cn.devzyh.common.utils.DictUtils;
import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.Map;

public class ModelUtils {

    /**
     * 加载全局变量信息
     */
    public static void loadGlobal(Model model) {
        Map<String, String> siteInfoMap = new HashMap<>();
        DictUtils.getDictCache(WebConstants.Item.SITE_INFO.getValue()).forEach(data -> {
            siteInfoMap.put(data.getDictValue(), data.getDictLabel());
        });
        model.addAllAttributes(siteInfoMap);
    }

}
