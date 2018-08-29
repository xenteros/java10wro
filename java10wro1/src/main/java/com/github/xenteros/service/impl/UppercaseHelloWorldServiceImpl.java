package com.github.xenteros.service.impl;

import com.github.xenteros.service.HelloWorldService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("upper")
public class UppercaseHelloWorldServiceImpl implements HelloWorldService {

    @Override
    public String helloWorld() {
        return "HELLO WORLD!";
    }

    @Override
    public String helloName(String name) {
        return String.format("HELLO %s!", name.toUpperCase());
    }
}
