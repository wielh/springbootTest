package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.HelloGrpcService;

@RestController
public class HelloGrpcController {
    
    @Autowired
    private HelloGrpcService helloGrpcService;

    @GetMapping("/sayhello")
    public String sayHello(@RequestParam String name) {
        return helloGrpcService.sayHello(name);
    }
}
