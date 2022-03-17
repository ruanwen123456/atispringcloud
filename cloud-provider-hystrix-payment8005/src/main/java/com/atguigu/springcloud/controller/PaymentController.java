package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("/provider/findById/{id}")
    public CommonResult findById(@PathVariable("id") Long id){
        return paymentService.findByid(id);
    }

    @GetMapping("/provider/findTimeOutById/{id}")
    public CommonResult findTimeOutById(@PathVariable("id") Long id){
        return paymentService.findTimeoutByid(id);
    }
}
