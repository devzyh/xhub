package cn.devzyh.xhub.notebook.service;

import cn.devzyh.xhub.common.core.domain.R;
import cn.devzyh.xhub.notebook.domain.NoteCatalog;

import java.util.List;

/**
 * 笔记目录Service接口
 *
 * @author devzyh
 * @date 2022-05-18
 */
public interface INoteCatalogService {

    /**
     * 查询笔记目录列表
     *
     * @param noteCatalog 笔记目录
     * @return 笔记目录集合
     */
    List<NoteCatalog> selectNoteCatalogList(NoteCatalog noteCatalog);
    
    /**
     * 查询笔记目录
     *
     * @param id 笔记目录主键
     * @return 笔记目录
     */
    NoteCatalog selectNoteCatalogById(Long id);

    /**
     * 新增笔记目录
     *
     * @param noteCatalog 笔记目录
     * @return 结果
     */
    int insertNoteCatalog(NoteCatalog noteCatalog);

    /**
     * 修改笔记目录
     *
     * @param noteCatalog 笔记目录
     * @return 结果
     */
    int updateNoteCatalog(NoteCatalog noteCatalog);

    /**
     * 批量删除笔记目录
     *
     * @param ids 需要删除的笔记目录主键集合
     * @return 结果
     */
    R deleteNoteCatalogByIds(List<Long> ids);

    /**
     * 删除笔记目录信息
     *
     * @param id 笔记目录主键
     * @return 结果
     */
    int deleteNoteCatalogById(Long id);

    /**
     * 构建前端所需要树结构
     *
     * @param catalogs 目录列表
     * @return 树结构列表
     */
    List<NoteCatalog> buildCatalogTree(List<NoteCatalog> catalogs);
}
