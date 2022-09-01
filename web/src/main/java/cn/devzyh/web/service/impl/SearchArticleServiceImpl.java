package cn.devzyh.web.service.impl;

import cn.devzyh.common.constant.WebConstants;
import cn.devzyh.common.utils.DictUtils;
import cn.devzyh.common.utils.StringUtils;
import cn.devzyh.favorite.domain.FavArticle;
import cn.devzyh.favorite.mapper.FavArticleMapper;
import cn.devzyh.web.domain.dto.ResultDto;
import cn.devzyh.web.domain.dto.SearchDto;
import cn.devzyh.web.service.ISearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 文章搜索服务
 */
@Service("searchArticleService")
public class SearchArticleServiceImpl implements ISearchService {

    @Autowired
    private FavArticleMapper articleMapper;

    @Override
    public SearchDto search(String... keys) {
        // 获取基本信息
        String key = keys[0];
        SearchDto searchDto = new SearchDto();
        searchDto.setSearchKey(key);
        searchDto.setSearchType(WebConstants.SearchType.ARTICLE.getValue());
        if (StringUtils.isBlank(key)) {
            key = "";
            searchDto.setPageTitle("文章 - ");
        } else {
            searchDto.setPageTitle(key + " - 文章 - ");
        }

        // 获取文章信息
        List<ResultDto> resultDtoList = new LinkedList<>();
        FavArticle article = new FavArticle();
        article.setTitle(key);
        List<FavArticle> articleList = articleMapper.selectFavArticleList(article);
        for (FavArticle ta : articleList) {
            ResultDto resultDto = new ResultDto();
            resultDto.setTitle(ta.getTitle());
            resultDto.setUrl(ta.getUrl());
            resultDto.setPostDate(ta.getCreated());
            resultDto.setDigest(ta.getDigest());
            resultDto.setImage(DictUtils.getDictLabel(WebConstants.Item.ARTICLE_SOURCE_IMAGE.getValue(), ta.getSource()));
            resultDto.setSource(DictUtils.getDictLabel(WebConstants.Item.ARTICLE_SOURCE.getValue(), ta.getSource()));
            resultDto.setTags(ta.getTags().stream()
                    .map(val -> DictUtils.getDictLabel(WebConstants.Item.ARTICLE_TAG.getValue(), val))
                    .collect(Collectors.toList()));
            resultDtoList.add(resultDto);
        }
        searchDto.setResultList(resultDtoList);
        return searchDto;
    }

}
