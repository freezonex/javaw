package com.supos.app.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import static com.supos.app.impl.SampleMail.sendMail;

/**
 * @Description  APP健康检查（APP必须提供health健康检查服务）
 * @Author chenfei
 * @Date 2021/4/13 17:45
 */
@Slf4j
@RestController
public class HealthController {

    @RequestMapping("/health")
    public String health() {
        log.info("App health check.");
        return "health";
    }

    @GetMapping("/mail/{mail}")
    public String mail(@PathVariable("mail") String mail) throws IOException {
        sendMail(mail);
        return "{\"result\":\"我执行完了，外瑞古达\"}";
    }

}
