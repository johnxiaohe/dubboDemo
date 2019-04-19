package com.dudemo.dudemoconsumer.controller;


import com.dudemo.dudemoiprovider.service.UserInfoISV;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Reference(version="1.0.0")
    private UserInfoISV userInfoISV;

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable("name")String name)throws Exception{

        return userInfoISV.sayHello(name);
    }


}
