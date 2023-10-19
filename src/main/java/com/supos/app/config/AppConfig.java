package com.supos.app.config;

import lombok.*;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

/**
 * @Description  APP配置项
 * @Author chenfei
 * @Date 2021/4/13 17:35
 */
@Component
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppConfig {

    /**
     * supOS地址
     */
    @Value("${supos.supos-address}")
    private String suposWebAddress;

    /**
     * supOS appId
     */
    @Value("${supos.app-id}")
    private String appId;

    /**
     * supOS appSecret
     */
    @Value("${supos.app-secret}")
    private String appSecret;
}
