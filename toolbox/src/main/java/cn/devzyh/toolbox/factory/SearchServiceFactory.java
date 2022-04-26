package cn.devzyh.toolbox.factory;

import cn.devzyh.common.constant.ToolConstants;
import cn.devzyh.toolbox.service.IToolSearchService;
import cn.devzyh.toolbox.service.impl.ToolToolSearchArticleServiceImpl;
import cn.devzyh.toolbox.service.impl.ToolToolSearchFavoriteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
public class SearchServiceFactory {

    @Autowired
    private WebApplicationContext ctx;

    /**
     * 获取搜索服务类实现
     *
     * @param type
     * @return
     */
    public IToolSearchService getService(String type) {
        ToolConstants.SearchType searchType = ToolConstants.SearchType.valueOf(type.toUpperCase());
        IToolSearchService service = null;
        switch (searchType) {
            case ARTICLE:
                service = ctx.getBean(ToolToolSearchArticleServiceImpl.class);
                break;
            case FAVORITE:
                service = ctx.getBean(ToolToolSearchFavoriteServiceImpl.class);
                break;
            default:
                break;
        }
        return service;
    }
}
