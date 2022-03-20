package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.controller.service.PayFeignServer;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import javafx.beans.DefaultProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
public class OrderController {

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private PayFeignServer payFeignServer;

    @GetMapping("/customer/payment/feignfind/{id}")
    public CommonResult<Payment> paymentZk(@PathVariable("id") Long id) throws InterruptedException {
        return payFeignServer.findByid(id);
    }
}
