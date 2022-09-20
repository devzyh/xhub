package cn.devzyh.xhub.web.domain.dto;

import com.github.pagehelper.PageInfo;

import java.io.Serializable;
import java.util.List;

/**
 * 搜索页面数据传输对象
 */
public class SearchDto implements Serializable {

    private static final long serialVersionUID = -6925704952000673323L;
    private String pageTitle; // 页面标题
    private String searchType; // 搜索源类型
    private String searchKey; // 搜索关键词
    private List<ResultDto> resultList; // 搜索结果
    private PageInfo page; // 分页数据

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public List<ResultDto> getResultList() {
        return resultList;
    }

    public void setResultList(List<ResultDto> resultList) {
        this.resultList = resultList;
    }

    public PageInfo getPage() {
        return page;
    }

    public void setPage(PageInfo page) {
        this.page = page;
    }
}
