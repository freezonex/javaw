package com.supos.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling //开启定时任务
@EnableAsync
public class AppJarDemoTowerApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(AppJarDemoTowerApplication.class, args);

//        SignUtil.run30();
    }

}
