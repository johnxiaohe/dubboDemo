package com.dudemo.dudemoconsumer.controller;


import com.dudemo.dudemoiprovider.service.UserInfoISV;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.validation.MethodValidated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    //将服务注册到不同的注册中心，从不同的注册中心取
    //check关闭该服务的启时检查默认为true 如果服务不可用会抛出异常组织spring启动。
    // 如果是false就会关闭该检查这样服务不存在时就不会启动不开了
    //retries 设置连接服务失败重连次数，默认为2
    //group  设置调用时那个分组下的服务 设置为*表示任意
    //mock 值为路径或者true、false 服务降级 在消费端定义逻辑为stu子集   通常用于服务降级，比如某验权服务，当服务提供方全部挂掉后，客户端不抛出异常，而是通过 Mock 数据返回授权失败。
    //actives = ,默认为0 每  客户端   并发执行（或占用连接的请求数）个数限制最多为多少
    //connections = 默认为0 限制客户端服务使用连接最大个数
    //sticky = true, 粘滞连接 注解属性模式开启  lazy = true, 延迟连接注解属性模式开启
    @Reference(version="1.0.0",registry = "registry1",check =false,retries = 5,mock = "com.dudemo.dudemoconsumer.**serviceMock")
    private UserInfoISV userInfoISV1;
    //loadBalance注解设置负载均衡 url服务器直连，免注册
    //cache 单独指定结果缓存
    //url 直接指定调用服务
    //async 设置消费者异步调用服务 true、false
    @Reference(version="1.0.0",url = "47.100.58.201:20880",registry="registry2",check =false,loadbalance = "roundrobin")
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
