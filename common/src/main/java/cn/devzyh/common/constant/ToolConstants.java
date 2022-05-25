package cn.devzyh.common.constant;

/**
 * 视图变量名称常量
 */
public class ToolConstants {

    /**
     * 工具视图
     */
    public class Home {
        public static final String FAVORITES = "favorites"; // 链接信息
    }

    /**
     * 搜索视图
     */
    public class Search {
        public static final String DATA = "data"; // 搜索结果数据
    }

    /**
     * 笔记视图
     */
    public class Note {
        public static final String DATA = "data"; // 页面结果数据
        public static final String NOTE = "note"; // 笔记内容数据
        public static final String TOKEN_PREFIX = "note_access_token:"; // 访问Token前缀
        public static final int TOKEN_EXPIRE = 5; // 访问Token有效期，单位：分钟
    }

    /**
     * 配置大类
     */
    public enum Item {
        SITE_INFO("tool_site_info"), // 站点信息
        ARTICLE_TAG("tool_article_tag"), // 文章标签
        ARTICLE_SOURCE("tool_article_source"), // 文章来源平台
        ARTICLE_SOURCE_IMAGE("tool_article_source_image"), // 文章来源平台图像
        FAVORITE_ITEM_IMAGE("tool_favorite_item_image"); // 收藏分组图像

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
        FAVORITE("favorite"); // 收藏数据源

        private final String type;

        SearchType(String type) {
            this.type = type;
        }

        public String getValue() {
            return this.type;
        }
    }
}
