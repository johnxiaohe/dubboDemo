package com.dubbo.dudemoprovider.serviceImpl;

import com.dudemo.dudemoiprovider.service.UserInfoISV;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

@Component
@Service(version="1.0.0")
public class UserInfoISVImpl implements UserInfoISV{


    @Override
    public String sayHello(String name) {
        return "你好呀，"+name+"先生!";
    }
}
