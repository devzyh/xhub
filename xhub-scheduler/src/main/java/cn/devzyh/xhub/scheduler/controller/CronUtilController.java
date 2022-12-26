package cn.devzyh.xhub.scheduler.controller;

import cn.devzyh.xhub.scheduler.util.CronUtils;
import org.quartz.CronExpression;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Cron工具接口控制器
 *
 * @author ruoyi
 */
@RestController
@RequestMapping("/cron")
public class CronUtilController {

    @PostMapping("/run_time")
    public List<String> cronRunTime(@RequestParam String cron) {
        int size = 10;
        List<String> list = new ArrayList<>(size);
        try {
            if (!CronUtils.isValid(cron)) {
                list.add(CronUtils.getInvalidMessage(cron));
                return list;
            }

            Date next = new Date(System.currentTimeMillis());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            for (int i = 0; i < size; i++) {
                CronExpression expression = new CronExpression(cron);
                next = expression.getNextValidTimeAfter(next);
                list.add(sdf.format(next));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
