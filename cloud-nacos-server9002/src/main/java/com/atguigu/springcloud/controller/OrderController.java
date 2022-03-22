package com.atguigu.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @GetMapping("/findById/{id}")
    public String findById(@PathVariable("id") Long id){
        return "Nacos-Server-findById:::"+id;
    }
}
