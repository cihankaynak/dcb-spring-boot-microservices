package com.dailycodebuffer.cloud.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackMethodController {

    @GetMapping("/userServiceFallback")
    public String userServiceFallback(){
        return "User service is down!";
    }

    @GetMapping("/departmentServiceFallback")
    public String departmentServiceFallback(){
        return "Department service is down!";
    }
}
