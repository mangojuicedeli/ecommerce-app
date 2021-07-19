package com.example.secondservice;

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
@RequestMapping("/second-service")
@Slf4j
public class SecondServiceController {

    private final Environment env;

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome to the second service.";
    }

    @GetMapping("/message")
    public String message(@RequestHeader("second-request") String header) {
        log.info(header);
        return "Hello, World in the second service.";
    }

    @GetMapping("/check")
    public String check(HttpServletRequest request){
        log.info("server port={}",request.getServerPort());
        return String.format("Hi, there. This is a message from second service in port %s"
                , env.getProperty("local.server.port"));
    }
}
