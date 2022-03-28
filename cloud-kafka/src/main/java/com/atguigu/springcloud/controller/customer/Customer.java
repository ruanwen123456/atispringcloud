package com.atguigu.springcloud.controller.customer;


import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class Customer {

    @KafkaListener(topics = "${kafka.topics}")
    public void resMsg(String message){
        log.info("消费者接收到消息。。。。。。"+message);
    }


}
