package com.github.xenteros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
class Application {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(args));
        ApplicationContext ctx = SpringApplication.run(Application.class, args);

//        for (String beanDefinitionName : ctx.getBeanDefinitionNames()) {
//            System.out.println(beanDefinitionName);
//        }
//        System.out.println(ctx.getBean(HelloWorldController.class).helloWorld());

    }

}
