package cn.devzyh.favorite.service.impl;

import cn.devzyh.favorite.domain.FavLink;
import cn.devzyh.favorite.mapper.FavLinkMapper;
import cn.devzyh.favorite.service.IFavLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavLinkServiceImpl implements IFavLinkService {

    @Autowired
    private FavLinkMapper favLinkMapper;

    /**
     * 查询主页链接
     *
     * @param id 主页链接主键
     * @return 主页链接
     */
    @Override
    public FavLink selectFavLinkById(Long id) {
        return favLinkMapper.selectFavLinkById(id);
    }

    /**
     * 查询主页链接列表
     *
     * @param favLink 主页链接
     * @return 主页链接
     */
    @Override
    public List<FavLink> selectFavLinkList(FavLink favLink) {
        return favLinkMapper.selectFavLinkList(favLink);
    }

    /**
     * 新增主页链接
     *
     * @param favLink 主页链接
     * @return 结果
     */
    @Override
    public int insertFavLink(FavLink favLink) {
        return favLinkMapper.insertFavLink(favLink);
    }

    /**
     * 修改主页链接
     *
     * @param favLink 主页链接
     * @return 结果
     */
    @Override
    public int updateFavLink(FavLink favLink) {
        return favLinkMapper.updateFavLink(favLink);
    }

    /**
     * 批量删除主页链接
     *
     * @param ids 需要删除的主页链接主键
     * @return 结果
     */
    @Override
    public int deleteFavLinkByIds(Long[] ids) {
        return favLinkMapper.deleteFavLinkByIds(ids);
    }

    /**
     * 删除主页链接信息
     *
     * @param id 主页链接主键
     * @return 结果
     */
    @Override
    public int deleteFavLinkById(Long id) {
        return favLinkMapper.deleteFavLinkById(id);
    }
}
