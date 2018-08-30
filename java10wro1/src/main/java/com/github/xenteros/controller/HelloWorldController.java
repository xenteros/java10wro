package com.github.xenteros.controller;

import com.github.xenteros.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

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


    @GetMapping("/hello")
    public String helloNameParam(@RequestParam String name) {
        return helloWorldService.helloName(name);
    }

    @RequestMapping(method = GET, value = "/hello/{name}")
    public String helloNamePath(@PathVariable String name){
        return helloWorldService.helloName(name);
    }

    @PostMapping("/hello")
    public String helloNameBody(String name) {
        return helloWorldService.helloName(name);
    }



}
