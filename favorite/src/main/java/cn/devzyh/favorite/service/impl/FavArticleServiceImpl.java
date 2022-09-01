package cn.devzyh.favorite.service.impl;

import cn.devzyh.favorite.domain.FavArticle;
import cn.devzyh.favorite.mapper.FavArticleMapper;
import cn.devzyh.favorite.service.IFavArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 文章Service业务层处理
 *
 * @author devzyh
 * @date 2022-05-08
 */
@Service
public class FavArticleServiceImpl implements IFavArticleService {
    @Autowired
    private FavArticleMapper favArticleMapper;

    /**
     * 查询文章
     *
     * @param id 文章主键
     * @return 文章
     */
    @Override
    public FavArticle selectFavArticleById(Long id) {
        return favArticleMapper.selectFavArticleById(id);
    }

    /**
     * 查询文章列表
     *
     * @param favArticle 文章
     * @return 文章
     */
    @Override
    public List<FavArticle> selectFavArticleList(FavArticle favArticle) {
        return favArticleMapper.selectFavArticleList(favArticle);
    }

    /**
     * 新增文章
     *
     * @param favArticle 文章
     * @return 结果
     */
    @Override
    @Transactional
    public int insertFavArticle(FavArticle favArticle) {
        favArticleMapper.insertFavArticle(favArticle);
        favArticleMapper.insertFavArticleTags(favArticle);
        return 1;
    }

    /**
     * 修改文章
     *
     * @param favArticle 文章
     * @return 结果
     */
    @Override
    @Transactional
    public int updateFavArticle(FavArticle favArticle) {
        favArticleMapper.deleteFavArticleTagsById(favArticle.getId());
        favArticleMapper.insertFavArticleTags(favArticle);
        return favArticleMapper.updateFavArticle(favArticle);
    }

    /**
     * 批量删除文章
     *
     * @param ids 需要删除的文章主键
     * @return 结果
     */
    @Override
    public int deleteFavArticleByIds(Long[] ids) {
        int row = 0;
        for (Long id : ids) {
            deleteFavArticleById(id);
            row++;
        }
        return row;
    }

    /**
     * 删除文章信息
     *
     * @param id 文章主键
     * @return 结果
     */
    @Override
    @Transactional
    public int deleteFavArticleById(Long id) {
        favArticleMapper.deleteFavArticleTagsById(id);
        return favArticleMapper.deleteFavArticleById(id);
    }
}
