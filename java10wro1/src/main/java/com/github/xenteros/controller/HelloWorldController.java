package com.github.xenteros.controller;

import com.github.xenteros.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

//    @Autowired
    private HelloWorldService helloWorldService;

    @Autowired
    public HelloWorldController(/*@Qualifier("helloWorldServiceImpl")*/ HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

//    @Autowired
    public void setHelloWorldService(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    @RequestMapping("/")
    public String helloWorld() {
        return helloWorldService.helloWorld();
    }
}
