package com.supos.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class AppJarDemoTowerApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(AppJarDemoTowerApplication.class, args);

//        SignUtil.run30();
    }

}
