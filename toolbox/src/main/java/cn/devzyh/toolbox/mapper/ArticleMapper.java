package cn.devzyh.toolbox.mapper;

import cn.devzyh.toolbox.domain.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 文章数据层
 */
@Mapper
public interface ArticleMapper {

    /**
     * 模糊搜索标题
     *
     * @param key 关键字
     * @return
     */
    List<Article> search(@Param("key") String key);
}
