package cn.devzyh.xhub.framework.mapper;

import cn.devzyh.xhub.framework.domain.SysRoleDept;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 角色与部门关联表 数据层
 */
@Mapper
public interface SysRoleDeptMapper extends BaseMapper<SysRoleDept> {

    /**
     * 批量新增角色部门信息
     *
     * @param roleDeptList 角色部门列表
     * @return 结果
     */
    int batchRoleDept(List<SysRoleDept> roleDeptList);

}
