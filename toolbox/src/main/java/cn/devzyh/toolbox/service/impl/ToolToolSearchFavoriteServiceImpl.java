package cn.devzyh.toolbox.service.impl;

import cn.devzyh.common.constant.ToolConstants;
import cn.devzyh.toolbox.domain.ToolFavorite;
import cn.devzyh.toolbox.domain.vo.ResultVO;
import cn.devzyh.toolbox.domain.vo.SearchVO;
import cn.devzyh.toolbox.mapper.ToolFavoriteMapper;
import cn.devzyh.toolbox.service.IToolDictDataService;
import cn.devzyh.toolbox.service.IToolSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 文章搜索服务
 */
@Service
public class ToolToolSearchFavoriteServiceImpl implements IToolSearchService {

    @Autowired
    private ToolFavoriteMapper toolFavoriteMapper;
    @Autowired
    private IToolDictDataService IConfigService;

    @Override
    public SearchVO search(String key) {
        // 获取基本信息
        SearchVO searchVo = new SearchVO();
        searchVo.setSearchKey(key);
        searchVo.setSearchType(ToolConstants.SearchType.ARTICLE.getValue());
        if (key.equals("")) {
            searchVo.setPageTitle("收藏 - ");
        } else {
            searchVo.setPageTitle(key + " - 收藏 - ");
        }

        // 翻译对照
        Map<String, String> imageMap = IConfigService.getConfigMapByItem(ToolConstants.Item.FAVORITE_ITEM_IMAGE);

        // 获取文章信息
        List<ResultVO> resultVOList = new LinkedList<>();
        List<ToolFavorite> articleList = toolFavoriteMapper.search(key);
        LocalDate now = LocalDate.now();
        for (ToolFavorite toolFavorite : articleList) {
            ResultVO resultVo = new ResultVO();
            resultVo.setTitle(toolFavorite.getName());
            resultVo.setUrl(toolFavorite.getHref());
            resultVo.setPostDate(now);
            resultVo.setDigest(toolFavorite.getRemark());
            resultVo.setAvatar(imageMap.get(toolFavorite.getItem()));
            resultVo.setSource(toolFavorite.getItem());
            resultVo.setTags(Collections.singletonList(toolFavorite.getItem()));
            resultVOList.add(resultVo);
        }
        searchVo.setResultList(resultVOList);
        return searchVo;
    }

}
