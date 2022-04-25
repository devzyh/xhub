package cn.devzyh.toolbox.domain.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 搜索页面数据类
 */
public class SearchVO implements Serializable {

    private static final long serialVersionUID = -6925704952000673323L;
    private String pageTitle; // 页面标题
    private String searchType; // 搜索源类型
    private String searchKey; // 搜索关键词
    private List<ResultVO> resultList; // 搜索结果

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

    public List<ResultVO> getResultList() {
        return resultList;
    }

    public void setResultList(List<ResultVO> resultList) {
        this.resultList = resultList;
    }
}
