package cn.devzyh.toolbox.service;

import java.util.List;

import cn.devzyh.toolbox.domain.ToolArticle;

/**
 * 文章Service接口
 *
 * @author devzyh
 * @date 2022-05-08
 */
public interface IToolArticleService {
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
     * 批量删除文章
     *
     * @param ids 需要删除的文章主键集合
     * @return 结果
     */
    public int deleteToolArticleByIds(Long[] ids);

    /**
     * 删除文章信息
     *
     * @param id 文章主键
     * @return 结果
     */
    public int deleteToolArticleById(Long id);
}
