package com.atguigu.springcloud.service.Impl;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class PaymentServiceImpl implements PaymentService {

    @Value("${server.port}")
    private String serverport;

    @Override
    public CommonResult<Payment> findByid(Long id) {
        return new CommonResult<Payment>(400,"serverport:::"+serverport);
    }

    @Override
    public CommonResult<Payment> findTimeoutByid(Long id) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new CommonResult<Payment>(400,"serverport:::延时3秒:::"+serverport);
    }
}
