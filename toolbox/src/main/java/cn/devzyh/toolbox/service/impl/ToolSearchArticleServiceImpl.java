package cn.devzyh.toolbox.service.impl;

import cn.devzyh.common.constant.ToolConstants;
import cn.devzyh.common.utils.StringUtils;
import cn.devzyh.toolbox.domain.ToolArticle;
import cn.devzyh.toolbox.domain.vo.ResultVO;
import cn.devzyh.toolbox.domain.vo.SearchVO;
import cn.devzyh.toolbox.mapper.ToolArticleMapper;
import cn.devzyh.toolbox.service.IToolDictDataService;
import cn.devzyh.toolbox.service.IToolSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 文章搜索服务
 */
@Service("searchArticleService")
public class ToolSearchArticleServiceImpl implements IToolSearchService {

    @Autowired
    private ToolArticleMapper articleMapper;
    @Autowired
    private IToolDictDataService dictDataService;

    @Override
    public SearchVO search(String key) {
        // 获取基本信息
        SearchVO searchVo = new SearchVO();
        searchVo.setSearchKey(key);
        searchVo.setSearchType(ToolConstants.SearchType.ARTICLE.getValue());
        if (StringUtils.isBlank(key)) {
            key = "";
            searchVo.setPageTitle("文章 - ");
        } else {
            searchVo.setPageTitle(key + " - 文章 - ");
        }

        // 翻译对照
        Map<String, String> tagMap = dictDataService.getConfigMapByItem(ToolConstants.Item.ARTICLE_TAG);
        Map<String, String> sourceMap = dictDataService.getConfigMapByItem(ToolConstants.Item.ARTICLE_SOURCE);
        Map<String, String> imageMap = dictDataService.getConfigMapByItem(ToolConstants.Item.ARTICLE_SOURCE_IMAGE);

        // 获取文章信息
        List<ResultVO> resultVOList = new LinkedList<>();
        List<ToolArticle> toolArticleList = articleMapper.search(key);
        for (ToolArticle toolArticle : toolArticleList) {
            ResultVO resultVo = new ResultVO();
            resultVo.setTitle(toolArticle.getTitle());
            resultVo.setUrl(toolArticle.getUrl());
            resultVo.setPostDate(toolArticle.getCreated());
            resultVo.setDigest(toolArticle.getDigest());
            resultVo.setAvatar(imageMap.get(toolArticle.getSource()));
            resultVo.setSource(sourceMap.get(toolArticle.getSource()));
            resultVo.setTags(toolArticle.getTags().stream()
                    .map(tagMap::get)
                    .collect(Collectors.toList()));
            resultVOList.add(resultVo);
        }
        searchVo.setResultList(resultVOList);
        return searchVo;
    }

}
