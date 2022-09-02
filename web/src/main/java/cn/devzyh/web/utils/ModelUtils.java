package cn.devzyh.web.utils;

import cn.devzyh.common.constant.WebConstants;
import cn.devzyh.common.utils.DictUtils;
import cn.devzyh.common.utils.spring.SpringUtils;
import cn.devzyh.web.service.impl.LinkServiceImpl;
import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModelUtils {

    /**
     * 加载全局变量信息
     */
    public static void loadGlobal(Model model) {
        // 站点基本信息
        Map<String, Object> siteInfoMap = new HashMap<>();
        DictUtils.getDictCache(WebConstants.Item.SITE_INFO.getValue()).forEach(data -> {
            siteInfoMap.put(data.getDictValue(), data.getDictLabel());
        });
        // 底部友链信息
        List links = SpringUtils.getBean(LinkServiceImpl.class).selectTopNFriendLinks();
        siteInfoMap.put(WebConstants.Global.FRIENDS, links);
        model.addAllAttributes(siteInfoMap);
    }

}
