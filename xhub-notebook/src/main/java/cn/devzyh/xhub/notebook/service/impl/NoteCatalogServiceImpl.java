package cn.devzyh.xhub.notebook.service.impl;

import cn.devzyh.xhub.common.core.domain.R;
import cn.devzyh.xhub.common.utils.StringUtils;
import cn.devzyh.xhub.notebook.domain.NoteCatalog;
import cn.devzyh.xhub.notebook.mapper.NoteCatalogMapper;
import cn.devzyh.xhub.notebook.service.INoteCatalogService;
import cn.devzyh.xhub.notebook.service.INoteContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 笔记目录Service业务层处理
 *
 * @author devzyh
 * @date 2022-05-18
 */
@Service
public class NoteCatalogServiceImpl implements INoteCatalogService {

    @Autowired
    private NoteCatalogMapper catalogMapper;

    @Autowired
    private INoteContentService contentService;

    /**
     * 查询笔记目录列表
     *
     * @param catalog 笔记目录
     * @return 笔记目录
     */
    @Override
    public List<NoteCatalog> selectNoteCatalogList(NoteCatalog catalog) {
        return catalogMapper.selectNoteCatalogList(catalog);
    }

    /**
     * 查询笔记目录
     *
     * @param id 笔记目录主键
     * @return 笔记目录
     */
    @Override
    public NoteCatalog selectNoteCatalogById(Long id) {
        return catalogMapper.selectById(id);
    }

    /**
     * 新增笔记目录
     *
     * @param catalog 笔记目录
     * @return 结果
     */
    @Override
    public int insertNoteCatalog(NoteCatalog catalog) {
        return catalogMapper.insert(catalog);
    }

    /**
     * 修改笔记目录
     *
     * @param catalog 笔记目录
     * @return 结果
     */
    @Override
    public int updateNoteCatalog(NoteCatalog catalog) {
        return catalogMapper.updateById(catalog);
    }

    /**
     * 批量删除笔记目录
     *
     * @param ids 需要删除的笔记目录主键
     * @return 结果
     */
    @Override
    public R deleteNoteCatalogByIds(List<Long> ids) {
        // 检查目录下是否有文章
        if (contentService.selectCountByCatalogIds(ids) > 0) {
            return R.fail("所选目录下存在关联文章");
        }

        catalogMapper.deleteBatchIds(ids);
        return R.ok();
    }

    /**
     * 删除笔记目录信息
     *
     * @param id 笔记目录主键
     * @return 结果
     */
    @Override
    public int deleteNoteCatalogById(Long id) {
        return catalogMapper.deleteById(id);
    }

    /**
     * 构建前端所需要树结构
     *
     * @param depts 部门列表
     * @return 树结构列表
     */
    @Override
    public List<NoteCatalog> buildCatalogTree(List<NoteCatalog> catalogs) {
        List<NoteCatalog> returnList = new ArrayList<NoteCatalog>();
        List<Long> tempList = new ArrayList<Long>();
        for (NoteCatalog catalog : catalogs) {
            tempList.add(catalog.getId());
        }
        for (NoteCatalog catalog : catalogs) {
            // 如果是顶级节点, 遍历该父节点的所有子节点
            if (!tempList.contains(catalog.getParentId())) {
                recursionFn(catalogs, catalog);
                returnList.add(catalog);
            }
        }
        if (returnList.isEmpty()) {
            returnList = catalogs;
        }
        return returnList;
    }

    /**
     * 递归列表
     */
    private void recursionFn(List<NoteCatalog> list, NoteCatalog t) {
        // 得到子节点列表
        List<NoteCatalog> childList = getChildList(list, t);
        t.setChildren(childList);
        for (NoteCatalog tChild : childList) {
            if (hasChild(list, tChild)) {
                recursionFn(list, tChild);
            }
        }
    }

    /**
     * 得到子节点列表
     */
    private List<NoteCatalog> getChildList(List<NoteCatalog> list, NoteCatalog t) {
        List<NoteCatalog> tlist = new ArrayList<NoteCatalog>();
        Iterator<NoteCatalog> it = list.iterator();
        while (it.hasNext()) {
            NoteCatalog n = (NoteCatalog) it.next();
            if (StringUtils.isNotNull(n.getParentId()) && n.getParentId().longValue() == t.getId().longValue()) {
                tlist.add(n);
            }
        }
        return tlist;
    }

    /**
     * 判断是否有子节点
     */
    private boolean hasChild(List<NoteCatalog> list, NoteCatalog t) {
        return getChildList(list, t).size() > 0;
    }
}
