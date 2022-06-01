package cn.devzyh.toolbox.service.impl;

import cn.devzyh.common.constant.ToolConstants;
import cn.devzyh.common.utils.DictUtils;
import cn.devzyh.common.utils.StringUtils;
import cn.devzyh.toolbox.domain.ToolFavorite;
import cn.devzyh.toolbox.domain.vo.ResultVo;
import cn.devzyh.toolbox.domain.vo.SearchVo;
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
    public SearchVo search(String key) {
        // 获取基本信息
        SearchVo searchVo = new SearchVo();
        searchVo.setSearchKey(key);
        searchVo.setSearchType(ToolConstants.SearchType.FAVORITE.getValue());
        if (StringUtils.isBlank(key)) {
            key = "";
            searchVo.setPageTitle("收藏 - ");
        } else {
            searchVo.setPageTitle(key + " - 收藏 - ");
        }

        // 获取文章信息
        List<ResultVo> resultVoList = new LinkedList<>();
        ToolFavorite favorite = new ToolFavorite();
        favorite.setName(key);
        List<ToolFavorite> favoriteList = favoriteMapper.selectToolFavoriteList(favorite);
        LocalDate now = LocalDate.now();
        for (ToolFavorite tf : favoriteList) {
            ResultVo resultVo = new ResultVo();
            resultVo.setTitle(tf.getName());
            resultVo.setUrl(tf.getHref());
            resultVo.setPostDate(now);
            resultVo.setDigest(tf.getRemark());
            resultVo.setSource(tf.getItem());
            resultVo.setTags(Collections.singletonList(tf.getItem()));
            resultVo.setImage(DictUtils.getDictLabel(ToolConstants.Item.FAVORITE_ITEM_IMAGE.getValue(), tf.getItem()));
            resultVoList.add(resultVo);
        }
        searchVo.setResultList(resultVoList);
        return searchVo;
    }

}
