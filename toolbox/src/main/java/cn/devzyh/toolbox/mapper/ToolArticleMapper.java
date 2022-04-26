package cn.devzyh.toolbox.mapper;

import cn.devzyh.toolbox.domain.ToolArticle;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 文章数据层
 */
public interface ToolArticleMapper {

    /**
     * 模糊搜索标题
     *
     * @param key 关键字
     * @return
     */
    List<ToolArticle> search(@Param("key") String key);
}
