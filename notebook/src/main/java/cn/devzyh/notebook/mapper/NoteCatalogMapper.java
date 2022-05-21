package cn.devzyh.notebook.mapper;

import java.util.List;

import cn.devzyh.notebook.domain.NoteCatalog;

/**
 * 笔记目录Mapper接口
 *
 * @author devzyh
 * @date 2022-05-18
 */
public interface NoteCatalogMapper {
    /**
     * 查询笔记目录
     *
     * @param id 笔记目录主键
     * @return 笔记目录
     */
    public NoteCatalog selectNoteCatalogById(Long id);

    /**
     * 查询笔记目录列表
     *
     * @param noteCatalog 笔记目录
     * @return 笔记目录集合
     */
    public List<NoteCatalog> selectNoteCatalogList(NoteCatalog noteCatalog);

    /**
     * 新增笔记目录
     *
     * @param noteCatalog 笔记目录
     * @return 结果
     */
    public int insertNoteCatalog(NoteCatalog noteCatalog);

    /**
     * 修改笔记目录
     *
     * @param noteCatalog 笔记目录
     * @return 结果
     */
    public int updateNoteCatalog(NoteCatalog noteCatalog);

    /**
     * 删除笔记目录
     *
     * @param id 笔记目录主键
     * @return 结果
     */
    public int deleteNoteCatalogById(Long id);

    /**
     * 批量删除笔记目录
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteNoteCatalogByIds(Long[] ids);
}