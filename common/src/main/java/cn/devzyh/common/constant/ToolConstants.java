package cn.devzyh.common.constant;

/**
 * 视图变量名称常量
 */
public class ToolConstants {

    /**
     * 工具视图
     */
    public class Index {
        public static final String FAVORITES = "favorites"; // 链接信息
    }

    /**
     * 搜索视图
     */
    public class Search {
        public static final String DATA = "data"; // 搜索结果数据
    }

    /**
     * 配置大类
     */
    public enum Item {
        SITE_INFO("SITE_INFO"), // 站点信息
        ARTICLE_TAG("ARTICLE_TAG"), // 文章标签
        ARTICLE_SOURCE("ARTICLE_SOURCE"), // 文章来源平台
        ARTICLE_SOURCE_IMAGE("ARTICLE_SOURCE_IMAGE"), // 文章来源平台图像
        FAVORITE_ITEM_IMAGE("FAVORITE_ITEM_IMAGE"); // 收藏分组图像

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
