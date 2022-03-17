package com.atguigu.springcloud.controller.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderZkController {

    public static final String zkUrl = "http://cloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consume/payment/zk")
    public String paymentZk(){
        log.info("zk:::paymentZk");
        return  restTemplate.getForObject(zkUrl+"/payment/zk",String.class);
    }
}
