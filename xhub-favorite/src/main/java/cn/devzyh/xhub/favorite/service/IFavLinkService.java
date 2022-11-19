package cn.devzyh.xhub.favorite.service;

import cn.devzyh.xhub.favorite.domain.FavLink;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * 收藏夹服务层
 */
public interface IFavLinkService {

    /**
     * 查询主页链接列表
     *
     * @param favLink 主页链接
     * @return 主页链接集合
     */
    List<FavLink> selectFavLinkList(IPage<FavLink> page, FavLink favLink);

    /**
     * 查询主页链接
     *
     * @param id 主页链接主键
     * @return 主页链接
     */
    FavLink selectFavLinkById(Long id);

    /**
     * 新增主页链接
     *
     * @param favLink 主页链接
     * @return 结果
     */
    int insertFavLink(FavLink favLink);

    /**
     * 修改主页链接
     *
     * @param favLink 主页链接
     * @return 结果
     */
    int updateFavLink(FavLink favLink);

    /**
     * 批量删除主页链接
     *
     * @param ids 需要删除的主页链接主键集合
     * @return 结果
     */
    int deleteFavLinkByIds(List<Long> ids);

    /**
     * 删除主页链接信息
     *
     * @param id 主页链接主键
     * @return 结果
     */
    int deleteFavLinkById(Long id);

    /**
     * 保存首页访问量数据到库
     */
    void saveLinkVisitsToDb();

}
