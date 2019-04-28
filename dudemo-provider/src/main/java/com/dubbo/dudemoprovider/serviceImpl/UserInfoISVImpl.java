package com.dubbo.dudemoprovider.serviceImpl;

import com.dudemo.dudemoiprovider.service.UserInfoISV;
import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.validation.MethodValidated;
import org.springframework.stereotype.Component;

@Component
//将服务注册到两个不同的注册中心上 registry
//loadbalance 服务级别的 表示负载均衡策略
//protocol多协议暴露服务 注解模式
//stub 注解方式进行本地存根 具体看官方文档 远程服务后，客户端通常只剩下接口，而实现全在服务器端，但提供方有些时候想在客户端也执行部分逻辑，比如：做 ThreadLocal 缓存，提前验证参数，调用失败后伪造容错数据等等，此时就需要在 API 中带上 Stub，客户端生成 Proxy 实例，会把 Proxy 通过构造函数传给 Stub，然后把 Stub 暴露给用户，Stub 可以决定要不要去调 Proxy。
//executes = 0 默认为0 并发控制 服务器端   并发执行（或占用线程池线程数）个数限制最多为多少
//actives = 0 默认为0 每  客户端   并发执行（或占用连接的请求数）个数限制最多为多少  或者可以在客户端限制
//connections = , 限制客户端服务使用连接最大个数  还是如果客户端和服务端都配置了 客户端配置优先
//token = true/随机字符自己设置,服务级别的令牌验证
@Service(version="1.0.0",stub = "com.dubbo.dudemoprovider.serviceStub",registry = {"registry1","registry2"},loadbalance = "roundrobin",protocol = {"dubbo","rmi"})
public class UserInfoISVImpl implements UserInfoISV{


    @Override
    public String sayHello(String name) {
        return "你好呀，"+name+"先生!";
    }
}
