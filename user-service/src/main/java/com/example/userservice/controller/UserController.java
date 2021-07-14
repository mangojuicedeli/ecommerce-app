package com.example.userservice.controller;

import com.example.userservice.vo.Greeting;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {

    private Environment env;
    private Greeting greeting;

    @GetMapping("/welcome")
    public String welcome() {
//        return env.getProperty("greeting.message");
        return greeting.getMessage();
    }

    @GetMapping("/health_check")
    public String status() {
        return "It's working in user-service.";
    }
}
