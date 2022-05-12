package cn.devzyh.toolbox.service.impl;

import cn.devzyh.common.constant.ToolConstants;
import cn.devzyh.common.utils.DictUtils;
import cn.devzyh.common.utils.StringUtils;
import cn.devzyh.toolbox.domain.ToolFavorite;
import cn.devzyh.toolbox.domain.vo.ResultVO;
import cn.devzyh.toolbox.domain.vo.SearchVO;
import cn.devzyh.toolbox.mapper.ToolFavoriteMapper;
import cn.devzyh.toolbox.service.IToolSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 文章搜索服务
 */
@Service("searchFavoriteService")
public class ToolSearchFavoriteServiceImpl implements IToolSearchService {

    @Autowired
    private ToolFavoriteMapper favoriteMapper;

    @Override
    public SearchVO search(String key) {
        // 获取基本信息
        SearchVO searchVo = new SearchVO();
        searchVo.setSearchKey(key);
        searchVo.setSearchType(ToolConstants.SearchType.FAVORITE.getValue());
        if (StringUtils.isBlank(key)) {
            key = "";
            searchVo.setPageTitle("收藏 - ");
        } else {
            searchVo.setPageTitle(key + " - 收藏 - ");
        }

        // 获取文章信息
        List<ResultVO> resultVOList = new LinkedList<>();
        ToolFavorite favorite = new ToolFavorite();
        favorite.setName(key);
        List<ToolFavorite> articleList = favoriteMapper.selectToolFavoriteList(favorite);
        LocalDate now = LocalDate.now();
        for (ToolFavorite toolFavorite : articleList) {
            ResultVO resultVo = new ResultVO();
            resultVo.setTitle(toolFavorite.getName());
            resultVo.setUrl(toolFavorite.getHref());
            resultVo.setPostDate(now);
            resultVo.setDigest(toolFavorite.getRemark());
            resultVo.setSource(toolFavorite.getItem());
            resultVo.setTags(Collections.singletonList(toolFavorite.getItem()));
            resultVo.setAvatar(DictUtils.getDictLabel(ToolConstants.Item.FAVORITE_ITEM_IMAGE.getValue(), toolFavorite.getItem()));
            resultVOList.add(resultVo);
        }
        searchVo.setResultList(resultVOList);
        return searchVo;
    }

}
