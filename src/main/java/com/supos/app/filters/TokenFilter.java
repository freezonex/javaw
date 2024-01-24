package com.supos.app.filters;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpStatus;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author caonuoqi@supos.com
 * @date 2021/11/1
 */
@Component
@Slf4j
public class TokenFilter implements Filter {
    @Value("${app.white-list}")
    String whiteList;
    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        Cookie[] cookies = request.getCookies();

        // 打印每个Cookie的名称和值
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                log.info("Cookie Name: " + cookie.getName() + ", Value: " + cookie.getValue() + "<br>");
            }
        } else {
            log.info("No cookies found");
        }

        String[] excludeUris = whiteList.split(";");
        if (excludeUris != null && excludeUris.length > 0) {
            for (int i = 0; i < excludeUris.length; i++) {
                Pattern p = Pattern.compile(excludeUris[i]);
                Matcher matcher = p.matcher(request.getRequestURI());
                boolean matched = matcher.find();
                if (matched) {
                    filterChain.doFilter(servletRequest, servletResponse);
                    return;
                }
            }
        }
        String userToken = request.getHeader("userToken");
        if (StrUtil.isNotBlank(userToken)) {
            // 与redis中的值进行比较
            if (ObjectUtils.isNotEmpty(redisTemplate.opsForValue().get(userToken))) {
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
        }
        JSONObject res = new JSONObject();
        res.put("code", 401);
        res.put("msg", "无权限访问");
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json; charset=utf-8");
        response.setStatus(HttpStatus.HTTP_UNAUTHORIZED);
        PrintWriter printWriter = response.getWriter();
        printWriter.write(res.toJSONString());
    }
}
