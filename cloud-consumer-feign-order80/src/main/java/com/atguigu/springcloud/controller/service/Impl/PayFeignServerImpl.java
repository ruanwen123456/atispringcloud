package com.atguigu.springcloud.controller.service.Impl;

import com.atguigu.springcloud.controller.service.PayFeignServer;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PayFeignServerImpl implements PayFeignServer {
    @Override
    public CommonResult<Payment> findByid(Long id) {
        return null;
    }
}
