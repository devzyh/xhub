package cn.devzyh.toolbox.service;

import cn.devzyh.toolbox.domain.ToolFavorite;

import java.util.List;
import java.util.Map;

/**
 * 收藏夹服务层
 */
public interface IToolFavoriteService {

    /**
     * 获取分组及工具详情
     *
     * @return
     */
    Map<String, List<ToolFavorite>> selectFavorites();

    /**
     * 查询主页链接
     *
     * @param id 主页链接主键
     * @return 主页链接
     */
    public ToolFavorite selectToolFavoriteById(Long id);

    /**
     * 查询主页链接列表
     *
     * @param toolFavorite 主页链接
     * @return 主页链接集合
     */
    public List<ToolFavorite> selectToolFavoriteList(ToolFavorite toolFavorite);

    /**
     * 新增主页链接
     *
     * @param toolFavorite 主页链接
     * @return 结果
     */
    public int insertToolFavorite(ToolFavorite toolFavorite);

    /**
     * 修改主页链接
     *
     * @param toolFavorite 主页链接
     * @return 结果
     */
    public int updateToolFavorite(ToolFavorite toolFavorite);

    /**
     * 批量删除主页链接
     *
     * @param ids 需要删除的主页链接主键集合
     * @return 结果
     */
    public int deleteToolFavoriteByIds(Long[] ids);

    /**
     * 删除主页链接信息
     *
     * @param id 主页链接主键
     * @return 结果
     */
    public int deleteToolFavoriteById(Long id);

}
