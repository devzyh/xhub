package cn.devzyh.xhub.framework.service.impl;

import cn.devzyh.xhub.common.core.domain.entity.SysDictData;
import cn.devzyh.xhub.common.utils.DictUtils;
import cn.devzyh.xhub.framework.mapper.SysDictDataMapper;
import cn.devzyh.xhub.framework.service.ISysDictDataService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 字典 业务层处理
 */
@Service
public class SysDictDataServiceImpl implements ISysDictDataService {

    @Autowired
    private SysDictDataMapper dictDataMapper;

    /**
     * 根据条件分页查询字典数据
     *
     * @param dictData 字典数据信息
     * @return 字典数据集合信息
     */
    @Override
    public List<SysDictData> selectDictDataList(IPage<SysDictData> page, SysDictData dictData) {
        return dictDataMapper.selectDictDataList(page, dictData);
    }

    /**
     * 根据条件分页查询字典数据
     *
     * @param dictType 字典类型
     * @return 字典数据集合信息
     */
    @Override
    public List<SysDictData> selectDictDataByType(String dictType) {
        QueryWrapper<SysDictData> qw = new QueryWrapper<>();
        qw.eq("status", "0");
        qw.eq("dict_type", dictType);
        qw.orderByAsc("dict_sort");
        return dictDataMapper.selectList(qw);
    }

    /**
     * 根据字典类型和字典键值查询字典数据信息
     *
     * @param dictType  字典类型
     * @param dictValue 字典键值
     * @return 字典标签
     */
    @Override
    public String selectDictLabel(String dictType, String dictValue) {
        QueryWrapper<SysDictData> qw = new QueryWrapper<>();
        qw.select("dict_label");
        qw.eq("dict_type", dictType);
        qw.eq("dict_value", dictValue);
        SysDictData data = dictDataMapper.selectOne(qw);
        if (data == null) {
            return null;
        }
        return data.getDictLabel();
    }

    /**
     * 根据字典数据ID查询信息
     *
     * @param dictCode 字典数据ID
     * @return 字典数据
     */
    @Override
    public SysDictData selectDictDataById(Long dictCode) {
        return dictDataMapper.selectById(dictCode);
    }

    /**
     * 批量删除字典数据信息
     *
     * @param dictCodes 需要删除的字典数据ID
     */
    @Override
    public void deleteDictDataByIds(Long[] dictCodes) {
        for (Long dictCode : dictCodes) {
            SysDictData data = selectDictDataById(dictCode);
            dictDataMapper.deleteById(dictCode);
            List<SysDictData> dictDatas = selectDictDataByType(data.getDictType());
            DictUtils.setDictCache(data.getDictType(), dictDatas);
        }
    }

    /**
     * 新增保存字典数据信息
     *
     * @param data 字典数据信息
     * @return 结果
     */
    @Override
    public int insertDictData(SysDictData data) {
        int row = dictDataMapper.insert(data);
        if (row > 0) {
            List<SysDictData> dictDatas = selectDictDataByType(data.getDictType());
            DictUtils.setDictCache(data.getDictType(), dictDatas);
        }
        return row;
    }

    /**
     * 修改保存字典数据信息
     *
     * @param data 字典数据信息
     * @return 结果
     */
    @Override
    public int updateDictData(SysDictData data) {
        int row = dictDataMapper.updateById(data);
        if (row > 0) {
            List<SysDictData> dictDatas = selectDictDataByType(data.getDictType());
            DictUtils.setDictCache(data.getDictType(), dictDatas);
        }
        return row;
    }
}
