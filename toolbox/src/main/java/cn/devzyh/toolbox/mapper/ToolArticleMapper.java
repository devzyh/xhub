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

    /**
     * 查询文章
     *
     * @param id 文章主键
     * @return 文章
     */
    public ToolArticle selectToolArticleById(Long id);

    /**
     * 查询文章列表
     *
     * @param toolArticle 文章
     * @return 文章集合
     */
    public List<ToolArticle> selectToolArticleList(ToolArticle toolArticle);

    /**
     * 新增文章
     *
     * @param toolArticle 文章
     * @return 结果
     */
    public int insertToolArticle(ToolArticle toolArticle);

    /**
     * 修改文章
     *
     * @param toolArticle 文章
     * @return 结果
     */
    public int updateToolArticle(ToolArticle toolArticle);

    /**
     * 删除文章
     *
     * @param id 文章主键
     * @return 结果
     */
    public int deleteToolArticleById(Long id);

    /**
     * 批量删除文章
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteToolArticleByIds(Long[] ids);

}
