package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;

public interface PaymentService {

    CommonResult<Payment> findByid(Long id);

    CommonResult<Payment> findTimeoutByid(Long id);
}
