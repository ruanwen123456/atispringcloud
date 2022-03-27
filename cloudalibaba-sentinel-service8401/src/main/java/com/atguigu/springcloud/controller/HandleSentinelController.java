package com.atguigu.springcloud.controller;


import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;

/**
 * 自定义降级方法
 */


public class HandleSentinelController {

    /**
     * block handle class
     * 对应的类必须为 static
     * @param exception
     * @return
     */
    public static CommonResult handleException(BlockException exception){
        return new CommonResult(200,"自定义限流");
    }
}
