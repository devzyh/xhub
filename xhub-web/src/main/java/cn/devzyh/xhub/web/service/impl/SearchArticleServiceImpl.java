package cn.devzyh.xhub.web.service.impl;

import cn.devzyh.xhub.common.constant.WebConstants;
import cn.devzyh.xhub.common.core.domain.entity.SysDictData;
import cn.devzyh.xhub.common.utils.DictUtils;
import cn.devzyh.xhub.common.utils.StringUtils;
import cn.devzyh.xhub.favorite.domain.FavArticle;
import cn.devzyh.xhub.favorite.mapper.FavArticleMapper;
import cn.devzyh.xhub.web.domain.dto.ResultDto;
import cn.devzyh.xhub.web.domain.dto.SearchDto;
import cn.devzyh.xhub.web.service.ISearchService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 文章搜索服务
 */
@Service("searchArticleService")
public class SearchArticleServiceImpl implements ISearchService {

    @Autowired
    private FavArticleMapper articleMapper;

    @Override
    public SearchDto search(Integer page, String... keys) {
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

        // 设置分页
        PageHelper.startPage(page, WebConstants.Search.PAGE_SIZE);

        // 获取文章信息
        List<ResultDto> resultDtoList = new LinkedList<>();
        FavArticle article = new FavArticle();
        article.setTitle(key);
        List<FavArticle> list = articleMapper.selectFavArticleList(article);
        HashMap<String, SysDictData> sourceMap = new HashMap();
        DictUtils.getDictCache(WebConstants.Item.ARTICLE_SOURCE.getValue()).forEach(it -> {
            sourceMap.put(it.getDictValue(), it);
        });
        for (FavArticle fa : list) {
            ResultDto resultDto = new ResultDto();
            resultDto.setTitle(fa.getTitle());
            resultDto.setUrl(fa.getUrl());
            resultDto.setPostDate(fa.getCreated());
            resultDto.setDigest(fa.getDigest());
            resultDto.setImage(sourceMap.get(fa.getSource()).getRemark());
            resultDto.setSource(sourceMap.get(fa.getSource()).getDictLabel());
            resultDto.setTags(fa.getTags());
            resultDtoList.add(resultDto);
        }

        searchDto.setResultList(resultDtoList);
        searchDto.setPage(new PageInfo(list));
        return searchDto;
    }

}
