package com.example.learn_srpring_security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello-world")
public class HelloWorldResource {

    @GetMapping
    public String helloWorld() {
        return "Hello World v1";
    }


}
