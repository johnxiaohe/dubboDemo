package com.dubbo.dudemoprovider.serviceImpl;

import com.dudemo.dudemoiprovider.service.UserInfoISV;
import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.validation.MethodValidated;
import org.springframework.stereotype.Component;

@Component
//将服务注册到两个不同的注册中心上 registry
//loadbalance 服务级别的 表示负载均衡策略
//protocol多协议暴露服务 注解模式
@Service(version="1.0.0",registry = {"registry1","registry2"},loadbalance = "roundrobin",protocol = {"dubbo","rmi"})
public class UserInfoISVImpl implements UserInfoISV{


    @Override
    public String sayHello(String name) {
        return "你好呀，"+name+"先生!";
    }
}
