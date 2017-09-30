package com.gs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/hello")
public class HelloController {

    /**
     * 默认使用get提交方式
     * */
    @RequestMapping(value = "hello",method = RequestMethod.GET)
    public String hello(){
        return "hello";
    }

    @RequestMapping("hi")
    @GetMapping
    public String hi(){
        return "hello";
    }
}
