package com.cbs.springcourse.rest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // @Controller + @ResponseBody над кожним методом
@RequestMapping("/api")
public class FirstRESTController {

    @GetMapping("/sayHello")
    public String sayHello() {
         return "Hello world!";
    }
}
