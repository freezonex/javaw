package com.supos.app;

import com.supos.app.aksk.SignUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppJarDemoTowerApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(AppJarDemoTowerApplication.class, args);

        SignUtil.run30();
    }

}
