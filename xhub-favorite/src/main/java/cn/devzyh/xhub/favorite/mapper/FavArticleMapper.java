package cn.devzyh.xhub.favorite.mapper;

import cn.devzyh.xhub.favorite.domain.FavArticle;

import java.util.List;

/**
 * 文章数据层
 */
public interface FavArticleMapper {

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
     * 删除文章
     *
     * @param id 文章主键
     * @return 结果
     */
    public int deleteFavArticleById(Long id);

    /**
     * 批量删除文章
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFavArticleByIds(Long[] ids);


    /**
     * 批量删除文章标签
     *
     * @param id 文章主键
     * @return 结果
     */
    public int deleteFavArticleTagsById(Long id);

    /**
     * 新增文章标签
     *
     * @param favArticle 文章
     * @return 结果
     */
    public int insertFavArticleTags(FavArticle favArticle);

}
