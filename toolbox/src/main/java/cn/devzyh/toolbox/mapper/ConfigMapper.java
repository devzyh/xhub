package cn.devzyh.toolbox.mapper;

import cn.devzyh.toolbox.domain.Config;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ConfigMapper {

    List<Config> findByItem(@Param("item") String item);
}
