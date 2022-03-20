package com.atguigu.springcloud.controller.service;

import com.atguigu.springcloud.controller.service.Impl.PayFeignServerImpl;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE",fallback = PayFeignServerImpl.class)
public interface PayFeignServer {

    @GetMapping(value = "/payment/feignfind/{id}")
    CommonResult<Payment> findByid(@PathVariable("id") Long id);
}
