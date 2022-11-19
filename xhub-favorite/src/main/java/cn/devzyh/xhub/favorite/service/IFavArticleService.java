package cn.devzyh.xhub.favorite.service;

import cn.devzyh.xhub.favorite.domain.FavArticle;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * 文章Service接口
 *
 * @author devzyh
 * @date 2022-05-08
 */
public interface IFavArticleService {

    /**
     * 查询文章列表
     *
     * @param favArticle 文章
     * @return 文章集合
     */
    List<FavArticle> selectFavArticleList(IPage<FavArticle> page, FavArticle favArticle);

    /**
     * 查询文章
     *
     * @param id 文章主键
     * @return 文章
     */
    FavArticle selectFavArticleById(Long id);

    /**
     * 新增文章
     *
     * @param favArticle 文章
     * @return 结果
     */
    int insertFavArticle(FavArticle favArticle);

    /**
     * 修改文章
     *
     * @param favArticle 文章
     * @return 结果
     */
    int updateFavArticle(FavArticle favArticle);

    /**
     * 批量删除文章
     *
     * @param ids 需要删除的文章主键集合
     * @return 结果
     */
    int deleteFavArticleByIds(List<Long> ids);

    /**
     * 删除文章信息
     *
     * @param id 文章主键
     * @return 结果
     */
    int deleteFavArticleById(Long id);
}
