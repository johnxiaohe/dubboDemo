package com.dubbo.dudemoprovider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.apache.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

//开启默认的dubbo设置 这个是必须要有的
@EnableDubbo
//@PropertySource("classpath:/spring/dubbo-provider.properties") 如果单独设置dubbo的配置可以添加这个注册 classpath表示是resource目录
@SpringBootApplication
public class DudemoProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(DudemoProviderApplication.class, args);
	}

}
//开启默认设置
