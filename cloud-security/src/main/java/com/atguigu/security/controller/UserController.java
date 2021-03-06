package com.atguigu.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/authentication/index")
    public String index() {
        return "index";
    }

    @GetMapping("/info")
    public Object info(Principal principal) {
        return principal;
    }
}
