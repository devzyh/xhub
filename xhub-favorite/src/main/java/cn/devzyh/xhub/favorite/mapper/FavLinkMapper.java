package cn.devzyh.xhub.favorite.mapper;

import cn.devzyh.xhub.favorite.domain.FavLink;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FavLinkMapper extends BaseMapper<FavLink> {


    /**
     * 查询主页链接列表
     *
     * @param favLink 主页链接
     * @return 主页链接集合
     */
    List<FavLink> selectFavLinkList(IPage<FavLink> page, @Param("data") FavLink favLink);

}
