package com.atguigu.security.controller;

import com.atguigu.security.model.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;

@Slf4j
@Controller
public class LoginController {

    @GetMapping("/authentication/login")
    public String authenticationLogin() throws IOException {
        return "login";
    }
    @GetMapping("/authentication/form")
    public String AuthLogin(UserDto userDto){
        log.info("登录成功::"+userDto.getUsername());
        return "redirect:/index";
    }

}
