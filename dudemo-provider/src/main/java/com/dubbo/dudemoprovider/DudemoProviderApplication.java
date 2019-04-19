package com.dubbo.dudemoprovider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.apache.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication
public class DudemoProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(DudemoProviderApplication.class, args);
	}

}
