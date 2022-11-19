package cn.devzyh.xhub.web.service.impl;

import cn.devzyh.xhub.common.constant.WebConstants;
import cn.devzyh.xhub.common.core.domain.entity.SysDictData;
import cn.devzyh.xhub.common.utils.DictUtils;
import cn.devzyh.xhub.common.utils.StringUtils;
import cn.devzyh.xhub.favorite.domain.FavArticle;
import cn.devzyh.xhub.favorite.service.IFavArticleService;
import cn.devzyh.xhub.favorite.service.IFavTagService;
import cn.devzyh.xhub.web.domain.dto.ResultDto;
import cn.devzyh.xhub.web.domain.dto.SearchDto;
import cn.devzyh.xhub.web.service.ISearchService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 文章搜索服务
 */
@Service("searchArticleService")
public class SearchArticleServiceImpl implements ISearchService {

    @Autowired
    private IFavArticleService favArticleService;
    @Autowired
    private IFavTagService favTagService;

    @Override
    public SearchDto search(Integer current, String... keys) {
        // 获取基本信息
        String key = keys[0];
        SearchDto searchDto = new SearchDto();
        searchDto.setSearchType(WebConstants.SearchType.ARTICLE.getValue());
        if (StringUtils.isBlank(key)) {
            key = "";
            searchDto.setPageTitle("文章 - ");
        } else {
            searchDto.setPageTitle(key + " - 文章 - ");
        }
        searchDto.setSearchKey(key);

        // 获取文章信息
        List<ResultDto> resultDtoList = new LinkedList<>();
        FavArticle article = new FavArticle();
        article.setTitle(key);
        Page<FavArticle> page = new Page<>(current, WebConstants.Search.PAGE_SIZE);
        List<FavArticle> list = favArticleService.selectFavArticleList(page, article);
        HashMap<String, SysDictData> sourceMap = new HashMap();
        DictUtils.getDictCache(WebConstants.Item.ARTICLE_SOURCE.getValue()).forEach(it -> {
            sourceMap.put(it.getDictValue(), it);
        });
        HashMap<Long, String> tagMap = new HashMap();
        favTagService.selectAllFavTag().forEach(it -> {
            tagMap.put(it.getId(), it.getName());
        });
        for (FavArticle fa : list) {
            ResultDto resultDto = new ResultDto();
            resultDto.setTitle(fa.getTitle());
            resultDto.setUrl(fa.getUrl());
            resultDto.setPostDate(fa.getReleaseDate());
            resultDto.setDigest(fa.getDigest());
            resultDto.setImage(sourceMap.get(fa.getSource()).getRemark());
            resultDto.setSource(sourceMap.get(fa.getSource()).getDictLabel());
            resultDto.setTags(fa.getTags().stream().map(tagMap::get).collect(Collectors.toList()));
            resultDtoList.add(resultDto);
        }

        searchDto.setResultList(resultDtoList);
        searchDto.setPage(page);
        return searchDto;
    }

}
