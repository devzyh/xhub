package cn.devzyh.xhub.framework.mapper;

import cn.devzyh.xhub.framework.domain.SysUserPost;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户与岗位关联表 数据层
 */
@Mapper
public interface SysUserPostMapper extends BaseMapper<SysUserPost> {

    /**
     * 批量新增用户岗位信息
     *
     * @param userPostList 用户角色列表
     * @return 结果
     */
    int batchUserPost(List<SysUserPost> userPostList);

}
