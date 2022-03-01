package com.atiguigu.springcloud.controller;


import com.atiguigu.springcloud.entities.CommonResult;
import com.atiguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderController {


    public static final String PAYMENT_URL = "http://localhost:8001";

    @Autowired
    private RestTemplate restTemplate;


    @PostMapping("/consumer/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){

        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }


    @GetMapping("/consumer/payment/find/{id}")
    public CommonResult<Payment> find(@PathVariable("id") Long id){

        return restTemplate.getForObject(PAYMENT_URL+"/payment/find/"+id,CommonResult.class);
    }
}
