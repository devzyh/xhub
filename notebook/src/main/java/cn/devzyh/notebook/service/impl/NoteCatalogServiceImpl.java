package cn.devzyh.notebook.service.impl;

import java.util.List;

import cn.devzyh.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.devzyh.notebook.mapper.NoteCatalogMapper;
import cn.devzyh.notebook.domain.NoteCatalog;
import cn.devzyh.notebook.service.INoteCatalogService;

/**
 * 笔记目录Service业务层处理
 *
 * @author devzyh
 * @date 2022-05-18
 */
@Service
public class NoteCatalogServiceImpl implements INoteCatalogService {
    @Autowired
    private NoteCatalogMapper noteCatalogMapper;

    /**
     * 查询笔记目录
     *
     * @param id 笔记目录主键
     * @return 笔记目录
     */
    @Override
    public NoteCatalog selectNoteCatalogById(Long id) {
        return noteCatalogMapper.selectNoteCatalogById(id);
    }

    /**
     * 查询笔记目录列表
     *
     * @param noteCatalog 笔记目录
     * @return 笔记目录
     */
    @Override
    public List<NoteCatalog> selectNoteCatalogList(NoteCatalog noteCatalog) {
        return noteCatalogMapper.selectNoteCatalogList(noteCatalog);
    }

    /**
     * 新增笔记目录
     *
     * @param noteCatalog 笔记目录
     * @return 结果
     */
    @Override
    public int insertNoteCatalog(NoteCatalog noteCatalog) {
        noteCatalog.setCreateTime(DateUtils.getNowDate());
        return noteCatalogMapper.insertNoteCatalog(noteCatalog);
    }

    /**
     * 修改笔记目录
     *
     * @param noteCatalog 笔记目录
     * @return 结果
     */
    @Override
    public int updateNoteCatalog(NoteCatalog noteCatalog) {
        noteCatalog.setUpdateTime(DateUtils.getNowDate());
        return noteCatalogMapper.updateNoteCatalog(noteCatalog);
    }

    /**
     * 批量删除笔记目录
     *
     * @param ids 需要删除的笔记目录主键
     * @return 结果
     */
    @Override
    public int deleteNoteCatalogByIds(Long[] ids) {
        return noteCatalogMapper.deleteNoteCatalogByIds(ids);
    }

    /**
     * 删除笔记目录信息
     *
     * @param id 笔记目录主键
     * @return 结果
     */
    @Override
    public int deleteNoteCatalogById(Long id) {
        return noteCatalogMapper.deleteNoteCatalogById(id);
    }
}
