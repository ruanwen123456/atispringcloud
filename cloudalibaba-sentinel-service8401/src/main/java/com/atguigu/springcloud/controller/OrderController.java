package com.atguigu.springcloud.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.BadLocationException;

@RestController
@Slf4j
public class OrderController {


    /**
     * 自定义降级 1
     * @return
     */
    @GetMapping("/testA")
    @SentinelResource(value = "testA",blockHandler = "handleException")
    public String testA(){
        return "method----testA-----------";
    }

    public String handleException(BlockException exception){
        return "method----testA-------被限流----";
    }

    /**
     * 自定义降级 2
     * 引用外部自定义方法
     * @return
     */
    @GetMapping("/testB")
    @SentinelResource(
            value = "testB"
            ,blockHandlerClass = {HandleSentinelController.class}
            ,blockHandler = "handleException"
    )
    public CommonResult testB(){
        return new CommonResult(200,"method----testB-----------");
    }
}
