package cn.devzyh.toolbox.service.impl;

import cn.devzyh.common.constant.ToolConstants;
import cn.devzyh.toolbox.domain.Article;
import cn.devzyh.toolbox.domain.vo.ResultVO;
import cn.devzyh.toolbox.domain.vo.SearchVO;
import cn.devzyh.toolbox.mapper.ArticleMapper;
import cn.devzyh.toolbox.service.IConfigService;
import cn.devzyh.toolbox.service.ISearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 文章搜索服务
 */
@Service
public class SearchArticleServiceImpl implements ISearchService {

    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private IConfigService IConfigService;

    @Override
    public SearchVO search(String key) {
        // 获取基本信息
        SearchVO searchVo = new SearchVO();
        searchVo.setSearchKey(key);
        searchVo.setSearchType(ToolConstants.SearchType.ARTICLE.getValue());
        if (key.equals("")) {
            searchVo.setPageTitle("文章 - ");
        } else {
            searchVo.setPageTitle(key + " - 文章 - ");
        }

        // 翻译对照
        Map<String, String> tagMap = IConfigService.getConfigMapByItem(ToolConstants.Item.ARTICLE_TAG);
        Map<String, String> sourceMap = IConfigService.getConfigMapByItem(ToolConstants.Item.ARTICLE_SOURCE);
        Map<String, String> imageMap = IConfigService.getConfigMapByItem(ToolConstants.Item.ARTICLE_SOURCE_IMAGE);

        // 获取文章信息
        List<ResultVO> resultVOList = new LinkedList<>();
        List<Article> articleList = articleMapper.search(key);
        for (Article article : articleList) {
            ResultVO resultVo = new ResultVO();
            resultVo.setTitle(article.getTitle());
            resultVo.setUrl(article.getUrl());
            resultVo.setPostDate(article.getCreated());
            resultVo.setDigest(article.getDigest());
            resultVo.setAvatar(imageMap.get(article.getSource()));
            resultVo.setSource(sourceMap.get(article.getSource()));
            resultVo.setTags(article.getTags().stream()
                    .map(tagMap::get)
                    .collect(Collectors.toList()));
            resultVOList.add(resultVo);
        }
        searchVo.setResultList(resultVOList);
        return searchVo;
    }

}
