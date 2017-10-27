package com.example.demo.controller;

import com.example.demo.properties.GrilProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

//@Controller -->RestController相当于Controller + ResponseBody
//@RequestMapping("hello")
@RestController
public class HelloController {

    @Value("${hello}")
    private String hello;

    @Value("${content}")
    private String content;

    @Autowired
    private GrilProperties grilProperties;

    //method 不选择的话，默认Get Post都可以访问
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value = {"/hello", "hi"}, method = RequestMethod.GET)
    public String hello(){
        return hello;
    }

    @RequestMapping(value = "/content", method = RequestMethod.GET)
    public String content(){
        return content;
    }

//    @RequestMapping(value = "/gril", method = RequestMethod.GET)
    @GetMapping(value = "/testGet")
    public String testGet(@RequestParam(value = "id", required = false, defaultValue = "0") Integer myId){
        return "gril's cupSize is " + grilProperties.getCupSize() + " , age is "+ grilProperties.getAge();
    }

//    @RequestMapping(value = "/gril", method = RequestMethod.POST)
    @PostMapping(value = "/testPost")
    public String testPost(){
        return "gril's cupSize is " + grilProperties.getCupSize() + " , age is "+ grilProperties.getAge();
    }

    @RequestMapping(value = "/testPathVariable/{id}", method = RequestMethod.GET)
    public Integer testPathVariable(@PathVariable("id") Integer myId){
        return myId;
    }


}
