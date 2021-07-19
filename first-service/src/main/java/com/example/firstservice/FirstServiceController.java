package com.example.firstservice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/first-service")
@Slf4j
public class FirstServiceController {

    private final Environment env;

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome to the first service.";
    }

    @GetMapping("/message")
    public String message(@RequestHeader("first-request") String header) {
        log.info(header);
        return "Hello, World in the first service.";
    }

    @GetMapping("/check")
    public String check(HttpServletRequest request){
        log.info("server port={}",request.getServerPort());
        return String.format("Hi, there. This is a message from first service in port %s"
                , env.getProperty("local.server.port"));
    }
}
