package com.supos.app.controller;

import com.alibaba.fastjson.JSONObject;
import com.bluetron.eco.sdk.api.SuposApi;
import com.bluetron.eco.sdk.dto.common.ApiResponse;
import com.supos.app.vo.AuthAccessToken;
import com.supos.app.vo.RestResult;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 前后端分离时跳转入口
 *
 * @author caonuoqi@supos.com
 */
@Controller
@RequestMapping("/auth")
public class RedirectController {
//    @Resource
//    private UserService userService;
    @Value("${app.prefix}")
    private String appPrefix;
    @Value("${app.supos-host}")
    private String suposHost;
    private final static Logger log = LoggerFactory.getLogger(RedirectController.class);
    @Resource
    private RedisTemplate redisTemplate;
    /**
     * 跳转入口<br>
     *
     * @param response
     */
    @ApiOperation(value = "授权",notes = "授权接口")
    @GetMapping("/authorize")
    public void auto(String redirect_url, HttpServletResponse response) {
        System.out.println(redirect_url);
        String location = SuposApi.authService.authorize(redirect_url, "1");
        log.info("重定向地址：{}", location);
        response.addHeader("Location", location);
        response.setStatus(HttpStatus.FOUND.value());
//        return;
    }
    @ApiOperation(value = "权限码",notes = "权限码跳转")
    @CrossOrigin
    @GetMapping("accessToken")
    @ResponseBody
    public RestResult accessToken(String code){
        String accessToken=null;
        ApiResponse apiResponse = SuposApi.authService.accessToken(code, "http://localhost:8080/health");
        String token = UUID.randomUUID().toString();
        if (apiResponse.getHttpCode() == 200) {
            AuthAccessToken authAccessToken = JSONObject.parseObject(apiResponse.getResponseBody(), AuthAccessToken.class);
            String key = authAccessToken.getUsername();
            String username = authAccessToken.getUsername();
            //TODO  host服务自身的权限业务,此处相当于应用原来的登录成功后操作 eg:
//            User loginUser = userService.getByName(username);
            //如果应用的用户表中没有用户 则使用open-api获取登录用户信息并插入用户表中
//            if (loginUser == null) {
//                loginUser = userService.saveAndGet(authAccessToken);
//            }
            accessToken=authAccessToken.getAccessToken();
            //TODO 将accessToken存在redis缓存中
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(token, accessToken, 43200, TimeUnit.SECONDS);
        }
        return new RestResult(0L,token,token);
    }
}
