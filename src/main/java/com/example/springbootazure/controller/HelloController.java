package com.example.springbootazure.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public Map<String, String> hello() {
        return Map.of("hello", "world");
    }

        @GetMapping("/hello2")
    public Map<String, String> hello2() {
        return Map.of("hello", "world!!");
    }

}