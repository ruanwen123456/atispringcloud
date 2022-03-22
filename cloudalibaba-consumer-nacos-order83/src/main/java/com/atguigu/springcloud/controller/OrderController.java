package com.atguigu.springcloud.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {

    @Value("${server-url}")
    private String serverUrl;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/conusmer/findById/{id}")
    public String findById(@PathVariable("id") Long id){
        log.info("conusmer-findById-"+id);
        return restTemplate.getForObject(serverUrl+"/findById/"+id,String.class);
    }

}
