package cn.devzyh.favorite.mapper;

import cn.devzyh.favorite.domain.FavLink;

import java.util.List;

public interface FavLinkMapper {

    /**
     * 查询主页链接
     *
     * @param id 主页链接主键
     * @return 主页链接
     */
    public FavLink selectFavLinkById(Long id);

    /**
     * 查询主页链接列表
     *
     * @param favLink 主页链接
     * @return 主页链接集合
     */
    public List<FavLink> selectFavLinkList(FavLink favLink);

    /**
     * 新增主页链接
     *
     * @param favLink 主页链接
     * @return 结果
     */
    public int insertFavLink(FavLink favLink);

    /**
     * 修改主页链接
     *
     * @param favLink 主页链接
     * @return 结果
     */
    public int updateFavLink(FavLink favLink);

    /**
     * 删除主页链接
     *
     * @param id 主页链接主键
     * @return 结果
     */
    public int deleteFavLinkById(Long id);

    /**
     * 批量删除主页链接
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFavLinkByIds(Long[] ids);

}
