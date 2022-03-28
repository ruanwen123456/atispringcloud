package com.atguigu.springcloud.controller.producer;


import com.atguigu.springcloud.entities.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class Producer {

    @Resource
    private KafkaTemplate kafkaTemplate;

    @Value("${kafka.topics}")
    private String kafkaTopic;

    @GetMapping("/msg/sendMsg/{message}")
    public CommonResult sendMsg(@PathVariable(value = "message",required = true) String message){
        log.info("send msg success");
        kafkaTemplate.send(kafkaTopic,message);
        return new CommonResult(200,"send msg success");
    }
}
