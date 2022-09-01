package cn.devzyh.web.service.impl;

import cn.devzyh.common.constant.WebConstants;
import cn.devzyh.common.utils.DictUtils;
import cn.devzyh.common.utils.StringUtils;
import cn.devzyh.favorite.domain.FavLink;
import cn.devzyh.favorite.mapper.FavLinkMapper;
import cn.devzyh.web.domain.dto.ResultDto;
import cn.devzyh.web.domain.dto.SearchDto;
import cn.devzyh.web.service.ISearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 文章搜索服务
 */
@Service("searchLinkService")
public class SearchLinkServiceImpl implements ISearchService {

    @Autowired
    private FavLinkMapper favoriteMapper;

    @Override
    public SearchDto search(String... keys) {
        // 获取基本信息
        String type = keys[0];
        String key = keys[1];

        SearchDto searchDto = new SearchDto();
        searchDto.setSearchKey(key);
        searchDto.setSearchType(WebConstants.SearchType.FAVORITE.getValue());
        if (StringUtils.isBlank(key)) {
            key = "";
            searchDto.setPageTitle("收藏 - ");
        } else {
            searchDto.setPageTitle(key + " - 收藏 - ");
        }

        // 获取文章信息
        List<ResultDto> resultDtoList = new LinkedList<>();
        FavLink favorite = new FavLink();
        switch (type) {
            case WebConstants.SearchParamsType.KEY:
                favorite.setName(key);
                break;
            case WebConstants.SearchParamsType.ITEM:
                favorite.setItem(key);
                break;
        }
        List<FavLink> list = favoriteMapper.selectFavLinkList(favorite);
        LocalDate now = LocalDate.now();
        for (FavLink link : list) {
            ResultDto resultDto = new ResultDto();
            resultDto.setTitle(link.getName());
            resultDto.setUrl(link.getHref());
            resultDto.setPostDate(now);
            resultDto.setDigest(link.getRemark());
            resultDto.setSource(link.getItem());
            resultDto.setTags(Collections.singletonList(link.getItem()));
            resultDto.setImage(DictUtils.getDictLabel(WebConstants.Item.FAVORITE_ITEM_IMAGE.getValue(), link.getItem()));
            resultDtoList.add(resultDto);
        }
        searchDto.setResultList(resultDtoList);
        return searchDto;
    }

}
