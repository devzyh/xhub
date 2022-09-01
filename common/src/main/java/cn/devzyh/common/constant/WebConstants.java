package cn.devzyh.common.constant;

/**
 * 视图变量名称常量
 */
public class WebConstants {

    /**
     * 首页链接 cache key
     */
    public static final String WEB_HOME_LINKS_KEY = "web_home_links";

    /**
     * 工具视图
     */
    public class Home {
        public static final String LINKS = "links"; // 链接信息
        public static final int SHOW_ITEM_LIMIT = 10; // 每组链接展示限制
    }

    /**
     * 搜索视图
     */
    public class Search {
        public static final String DATA = "data"; // 搜索结果数据
    }

    /**
     * 搜索视图参数类型
     */
    public class SearchParamsType {
        public static final String KEY = "key"; // 关键词搜索
        public static final String ITEM = "item"; // 按分类搜索
    }

    /**
     * 笔记视图
     */
    public class Note {
        public static final String DATA = "data"; // 页面结果数据
        public static final String NOTE = "note"; // 笔记内容数据
        public static final String TOKEN_PREFIX = "share_access_token:"; // 访问Token前缀
        public static final int TOKEN_EXPIRE = 5; // 访问Token有效期，单位：分钟
    }

    /**
     * 配置大类
     */
    public enum Item {
        SITE_INFO("web_site_info"), // 站点基本信息
        ARTICLE_TAG("web_article_tag"), // 文章标签信息
        ARTICLE_SOURCE("web_article_source"), // 文章来源平台
        ARTICLE_SOURCE_IMAGE("web_article_source_image"), // 来源平台图像
        LINK_ITEM_IMAGE("web_link_item_image"); // 链接分组图像

        private final String item;

        Item(String item) {
            this.item = item;
        }

        public String getValue() {
            return this.item;
        }
    }

    /**
     * 搜索类型
     */
    public enum SearchType {
        ARTICLE("article"), // 文章数据源
        LINK("link"); // 链接数据源

        private final String type;

        SearchType(String type) {
            this.type = type;
        }

        public String getValue() {
            return this.type;
        }
    }
}
