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
    //将服务注册到不同的注册中心，从不同的注册中心取
    @Reference(version="1.0.0",registry = "registry1")
    private UserInfoISV userInfoISV1;
    @Reference(version="1.0.0",registry="registry2")
    private UserInfoISV userInfoISV2;

    @GetMapping("/hello1/{name}")
    public String sayHello(@PathVariable("name")String name)throws Exception{
        System.out.println("调用了第一个地址");
        return userInfoISV1.sayHello(name);
    }
    @GetMapping("/hello2/{name}")
    public String sayHello2(@PathVariable("name")String name)throws Exception{
        System.out.println("调用了第二个地址");
        return userInfoISV2.sayHello(name);
    }


}
