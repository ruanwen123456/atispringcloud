package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import com.atguigu.springcloud.utils.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @ResponseBody
    @PostMapping("/payment/helllo")
    public String helllo(){
        return "helllo";
    }

    @ResponseBody
    @PostMapping("/payment/create")
    public CommonResult<Payment> savePayment(@RequestBody Payment payment){
        int result = paymentService.save(payment);
        log.info("***********插入结果********"+result+"::port::"+serverPort);

        if(result>0){
            return new CommonResult(Constant.RESULT_SUCCESS_CODE,Constant.RESULT_SUCCESS_MESSAGE,result);
        }
        return new CommonResult(Constant.RESULT_FAILD_CODE,Constant.RESULT_FAILD_MESSAGE,null);
    }

    @ResponseBody
    @GetMapping("/payment/find/{id}")
    public CommonResult<Payment> savePayment(@PathVariable("id") Long id){
        List<Payment> payList = paymentService.selectPaymentBYId(id);
        log.info("***********查询结果********"+payList+"::port::"+serverPort);

        if(payList != null){
            return new CommonResult(Constant.RESULT_SUCCESS_CODE,"查询成功serverPort::"+serverPort,payList);
        }
        return new CommonResult(Constant.RESULT_FAILD_CODE,Constant.RESULT_FAILD_MESSAGE,null);
    }

    @ResponseBody
    @GetMapping("/payment/feignfind/{id}")
    public CommonResult<Payment> findPayment(@PathVariable("id") Long id) throws InterruptedException {
        Thread.sleep(1000);
        log.info("***********查询结果********::port::"+serverPort);
        return new CommonResult(Constant.RESULT_SUCCESS_CODE,Constant.RESULT_FAILD_MESSAGE+"**********查询结果********::port::"+id,null);
    }


    @ResponseBody
    @GetMapping("/payment/discovery")
    public Object discover(){
        List<String> services =  discoveryClient.getServices();

        for(String service:services){
            log.info("********service*********"+service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("");
        for (ServiceInstance instance:instances){

            log.info(":::serviceId::"+instance.getServiceId()+"::: host :::"+instance.getHost()+"::::  url ::::"+instance.getUri());
        }

        return this.discoveryClient;
    }

}
