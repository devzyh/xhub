package cn.devzyh.web.service;

import cn.devzyh.web.domain.dto.ShareDto;

/**
 * 笔记Service接口
 *
 * @author devzyh
 * @date 2022-05-08
 */
public interface IShareService {

    /**
     * 查询笔记HTML
     *
     * @param id 文章主键
     * @return 文章
     */
    public ShareDto html(Long id, String secret, String token);

    /**
     * 查询笔记Markdown
     *
     * @param id 文章主键
     * @return 文章
     */
    public String markdown(Long id, String secret, String token);

}
