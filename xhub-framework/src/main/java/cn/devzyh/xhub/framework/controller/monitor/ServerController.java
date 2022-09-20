package cn.devzyh.xhub.framework.controller.monitor;

import cn.devzyh.xhub.framework.web.domain.Server;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.devzyh.xhub.common.core.domain.AjaxResult;

/**
 * 服务器监控
 *
 * @author ruoyi
 */
@RestController
@RequestMapping("/rest/monitor/server")
public class ServerController
{
    @PreAuthorize("@ss.hasPermi('monitor:server:list')")
    @GetMapping()
    public AjaxResult getInfo() throws Exception
    {
        Server server = new Server();
        server.copyTo();
        return AjaxResult.success(server);
    }
}
