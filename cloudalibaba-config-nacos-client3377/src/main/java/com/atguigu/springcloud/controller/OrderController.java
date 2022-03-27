package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RefreshScope
public class OrderController {

    @Value("${server.info}")
    private String serverInfo;

    @GetMapping("/config/getNacosConfig")
    public String getNacosConfig(){
        return serverInfo;
    }
}
