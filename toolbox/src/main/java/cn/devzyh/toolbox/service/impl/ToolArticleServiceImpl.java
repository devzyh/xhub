package cn.devzyh.toolbox.service.impl;

import cn.devzyh.toolbox.domain.ToolArticle;
import cn.devzyh.toolbox.mapper.ToolArticleMapper;
import cn.devzyh.toolbox.service.IToolArticleService;
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
public class ToolArticleServiceImpl implements IToolArticleService {
    @Autowired
    private ToolArticleMapper toolArticleMapper;

    /**
     * 查询文章
     *
     * @param id 文章主键
     * @return 文章
     */
    @Override
    public ToolArticle selectToolArticleById(Long id) {
        return toolArticleMapper.selectToolArticleById(id);
    }

    /**
     * 查询文章列表
     *
     * @param toolArticle 文章
     * @return 文章
     */
    @Override
    public List<ToolArticle> selectToolArticleList(ToolArticle toolArticle) {
        return toolArticleMapper.selectToolArticleList(toolArticle);
    }

    /**
     * 新增文章
     *
     * @param toolArticle 文章
     * @return 结果
     */
    @Override
    @Transactional
    public int insertToolArticle(ToolArticle toolArticle) {
        toolArticleMapper.insertToolArticle(toolArticle);
        toolArticleMapper.insertToolArticleTags(toolArticle);
        return 1;
    }

    /**
     * 修改文章
     *
     * @param toolArticle 文章
     * @return 结果
     */
    @Override
    @Transactional
    public int updateToolArticle(ToolArticle toolArticle) {
        toolArticleMapper.deleteToolArticleTagsById(toolArticle.getId());
        toolArticleMapper.insertToolArticleTags(toolArticle);
        return toolArticleMapper.updateToolArticle(toolArticle);
    }

    /**
     * 批量删除文章
     *
     * @param ids 需要删除的文章主键
     * @return 结果
     */
    @Override
    public int deleteToolArticleByIds(Long[] ids) {
        int row = 0;
        for (Long id : ids) {
            deleteToolArticleById(id);
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
    public int deleteToolArticleById(Long id) {
        toolArticleMapper.deleteToolArticleTagsById(id);
        return toolArticleMapper.deleteToolArticleById(id);
    }
}
