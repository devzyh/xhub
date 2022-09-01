package cn.devzyh.favorite.service;

import cn.devzyh.favorite.domain.FavArticle;

import java.util.List;

/**
 * 文章Service接口
 *
 * @author devzyh
 * @date 2022-05-08
 */
public interface IFavArticleService {
    /**
     * 查询文章
     *
     * @param id 文章主键
     * @return 文章
     */
    public FavArticle selectFavArticleById(Long id);

    /**
     * 查询文章列表
     *
     * @param favArticle 文章
     * @return 文章集合
     */
    public List<FavArticle> selectFavArticleList(FavArticle favArticle);

    /**
     * 新增文章
     *
     * @param favArticle 文章
     * @return 结果
     */
    public int insertFavArticle(FavArticle favArticle);

    /**
     * 修改文章
     *
     * @param favArticle 文章
     * @return 结果
     */
    public int updateFavArticle(FavArticle favArticle);

    /**
     * 批量删除文章
     *
     * @param ids 需要删除的文章主键集合
     * @return 结果
     */
    public int deleteFavArticleByIds(Long[] ids);

    /**
     * 删除文章信息
     *
     * @param id 文章主键
     * @return 结果
     */
    public int deleteFavArticleById(Long id);
}
