package cn.devzyh.toolbox.mapper;

import cn.devzyh.toolbox.domain.ToolFavorite;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ToolFavoriteMapper {

    /**
     * 查询所有工具
     *
     * @return 收藏列表
     */
    List<ToolFavorite> selectAll();

    /**
     * 模糊搜索标题
     *
     * @param key 关键字
     * @return
     */
    List<ToolFavorite> search(@Param("key") String key);

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
     * 删除主页链接
     *
     * @param id 主页链接主键
     * @return 结果
     */
    public int deleteToolFavoriteById(Long id);

    /**
     * 批量删除主页链接
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteToolFavoriteByIds(Long[] ids);

}
