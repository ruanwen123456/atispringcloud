package com.atguigu.springcloud.service.Impl;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


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

        return payment_info(id);
    }
    @HystrixCommand(defaultFallback = "payment_timeOut",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public CommonResult<Payment> payment_info(Long i){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new CommonResult<Payment>(400,"serverport:::延时3秒:::"+serverport);
    }
    public CommonResult<Payment> payment_timeOut(Long i){
        return new CommonResult<Payment>(400,"serverport:::延时降级:::"+serverport);
    }
}
