package com.example.learn_srpring_security.ressouces;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloWorldResource {

    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello World v1";
    }

}