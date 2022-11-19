package cn.devzyh.xhub.favorite.mapper;

import cn.devzyh.xhub.favorite.domain.FavArticle;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 文章数据层
 */
@Mapper
public interface FavArticleMapper extends BaseMapper<FavArticle> {

    /**
     * 查询文章列表
     *
     * @param favArticle 文章
     * @return 文章集合
     */
    List<FavArticle> selectFavArticleList(IPage<FavArticle> page, @Param("data") FavArticle favArticle);

    /**
     * 查询文章
     *
     * @param id 文章主键
     * @return 文章
     */
    FavArticle selectFavArticleById(Long id);

    /**
     * 批量删除文章标签
     *
     * @param id 文章主键
     * @return 结果
     */
    int deleteFavArticleTagsById(Long id);

    /**
     * 新增文章标签
     *
     * @param favArticle 文章
     * @return 结果
     */
    int insertFavArticleTags(FavArticle favArticle);

}
