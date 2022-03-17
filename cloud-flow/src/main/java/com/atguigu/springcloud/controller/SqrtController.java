package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.server.RunCaseServer;
import org.activiti.bpmn.converter.BpmnXMLConverter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @author xuan
 * @since 2020/8/16
 */
@RestController
public class SqrtController {

    @Resource
    private RunCaseServer runCaseServer;

    @RequestMapping("/hello")
    public String say() {
        return "Hello";
    }

    @RequestMapping("/run")
    public String run() {
        runCaseServer.run();
        return "正常运行";
    }

//    @RequestMapping("/run2")
//    public String run2() {
//        runCase.run2();
//        return "Run ok.";
//    }

}
