package cn.devzyh.xhub.web.service.impl;

import cn.devzyh.xhub.common.constant.WebConstants;
import cn.devzyh.xhub.common.core.domain.entity.SysDictData;
import cn.devzyh.xhub.common.utils.DictUtils;
import cn.devzyh.xhub.common.utils.StringUtils;
import cn.devzyh.xhub.favorite.domain.FavLink;
import cn.devzyh.xhub.favorite.service.IFavLinkService;
import cn.devzyh.xhub.web.domain.dto.ResultDto;
import cn.devzyh.xhub.web.domain.dto.SearchDto;
import cn.devzyh.xhub.web.service.ISearchService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 文章搜索服务
 */
@Service("searchLinkService")
public class SearchLinkServiceImpl implements ISearchService {

    @Autowired
    private IFavLinkService favLinkService;

    @Override
    public SearchDto search(Integer current, String... keys) {
        // 获取基本信息
        String type = keys[0];
        String key = keys[1];

        SearchDto searchDto = new SearchDto();
        searchDto.setSearchType(WebConstants.SearchType.LINK.getValue());
        if (StringUtils.isBlank(key)) {
            key = "";
            searchDto.setPageTitle("链接 - ");
        } else {
            searchDto.setPageTitle(key + " - 链接 - ");
        }
        searchDto.setSearchKey(key);

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

        Page<FavLink> page = new Page<>(current, WebConstants.Search.PAGE_SIZE);
        List<FavLink> list = favLinkService.selectFavLinkList(page, favorite);
        HashMap<String, SysDictData> itemMap = new HashMap();
        DictUtils.getDictCache(WebConstants.Item.LINK_ITEM.getValue()).forEach(it -> {
            itemMap.put(it.getDictValue(), it);
        });
        LocalDate now = LocalDate.now();
        for (FavLink link : list) {
            ResultDto resultDto = new ResultDto();
            resultDto.setTitle(link.getName());
            resultDto.setUrl(link.getHref());
            resultDto.setPostDate(now);
            resultDto.setDigest(link.getRemark());
            resultDto.setSource(itemMap.get(link.getItem()).getDictLabel());
            resultDto.setTags(Collections.singletonList(itemMap.get(link.getItem()).getDictLabel()));
            resultDto.setImage(itemMap.get(link.getItem()).getRemark());
            resultDtoList.add(resultDto);
        }

        searchDto.setResultList(resultDtoList);
        searchDto.setPage(page);
        return searchDto;
    }

}
