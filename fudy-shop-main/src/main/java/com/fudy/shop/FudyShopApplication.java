package com.fudy.shop;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@EnableDubbo(scanBasePackages="com.fudy.shop.interfaces.dubbo")
@SpringBootApplication
@EnableRedisHttpSession
@MapperScan("com.fudy.shop.infrastructure.db.mybatis.mapper")
public class FudyShopApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(FudyShopApplication.class, args);
		String name = context.getEnvironment().getProperty("name");
		System.out.println("name:"+name);
	}

}
