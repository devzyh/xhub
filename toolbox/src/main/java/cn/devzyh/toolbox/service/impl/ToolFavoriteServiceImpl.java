package cn.devzyh.toolbox.service.impl;

import cn.devzyh.toolbox.domain.ToolFavorite;
import cn.devzyh.toolbox.mapper.ToolFavoriteMapper;
import cn.devzyh.toolbox.service.IToolFavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class ToolFavoriteServiceImpl implements IToolFavoriteService {

    @Autowired
    private ToolFavoriteMapper toolFavoriteMapper;

    @Override
    public Map<String, List<ToolFavorite>> selectFavorites() {
        Map<String, List<ToolFavorite>> result = new HashMap<>();
        List<ToolFavorite> toolFavorites = toolFavoriteMapper.selectToolFavoriteList(new ToolFavorite());
        toolFavorites.forEach(toolFavorite -> {
            List<ToolFavorite> list = result.get(toolFavorite.getItem());
            if (list == null) {
                list = new LinkedList<>();
            }

            if (list.size() < 10) {
                list.add(toolFavorite);
                result.put(toolFavorite.getItem(), list);
            }
        });

        return result;
    }

    /**
     * 查询主页链接
     *
     * @param id 主页链接主键
     * @return 主页链接
     */
    @Override
    public ToolFavorite selectToolFavoriteById(Long id) {
        return toolFavoriteMapper.selectToolFavoriteById(id);
    }

    /**
     * 查询主页链接列表
     *
     * @param toolFavorite 主页链接
     * @return 主页链接
     */
    @Override
    public List<ToolFavorite> selectToolFavoriteList(ToolFavorite toolFavorite) {
        return toolFavoriteMapper.selectToolFavoriteList(toolFavorite);
    }

    /**
     * 新增主页链接
     *
     * @param toolFavorite 主页链接
     * @return 结果
     */
    @Override
    public int insertToolFavorite(ToolFavorite toolFavorite) {
        return toolFavoriteMapper.insertToolFavorite(toolFavorite);
    }

    /**
     * 修改主页链接
     *
     * @param toolFavorite 主页链接
     * @return 结果
     */
    @Override
    public int updateToolFavorite(ToolFavorite toolFavorite) {
        return toolFavoriteMapper.updateToolFavorite(toolFavorite);
    }

    /**
     * 批量删除主页链接
     *
     * @param ids 需要删除的主页链接主键
     * @return 结果
     */
    @Override
    public int deleteToolFavoriteByIds(Long[] ids) {
        return toolFavoriteMapper.deleteToolFavoriteByIds(ids);
    }

    /**
     * 删除主页链接信息
     *
     * @param id 主页链接主键
     * @return 结果
     */
    @Override
    public int deleteToolFavoriteById(Long id) {
        return toolFavoriteMapper.deleteToolFavoriteById(id);
    }
}
