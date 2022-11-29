package cn.devzyh.xhub.framework.controller.monitor;

import cn.devzyh.xhub.common.core.domain.Result;
import cn.devzyh.xhub.framework.web.domain.Server;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 服务器监控
 *
 * @author ruoyi
 */
@RestController
@RequestMapping("/rest/monitor/server")
public class ServerController {
    @PreAuthorize("@ss.hasPermi('monitor:server:list')")
    @GetMapping()
    public Result getInfo() throws Exception {
        Server server = new Server();
        server.copyTo();
        return Result.success(server);
    }
}
