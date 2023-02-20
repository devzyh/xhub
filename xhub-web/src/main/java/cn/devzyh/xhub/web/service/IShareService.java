package cn.devzyh.xhub.web.service;

import cn.devzyh.xhub.web.domain.dto.ShareDto;

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
     * @param id  文章主键
     * @param secret 访问密钥
     * @return 文章
     */
    ShareDto html(Long id, String secret);

    /**
     * 查询笔记Markdown
     *
     * @param id  文章主键
     * @param secret 访问密钥
     * @return 文章
     */
    String markdown(Long id, String secret);

}
