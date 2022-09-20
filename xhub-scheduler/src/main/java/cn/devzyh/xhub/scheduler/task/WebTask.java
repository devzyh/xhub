package cn.devzyh.xhub.scheduler.task;

import cn.devzyh.xhub.favorite.service.IFavLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Web模块任务
 *
 * @author ruoyi
 */
@Component("webTask")
public class WebTask {

    @Autowired
    IFavLinkService favLinkService;

    /**
     * 首页链接访问量落库
     */
    public void linkVisitsToDb() {
        favLinkService.saveLinkVisitsToDb();
    }
}
