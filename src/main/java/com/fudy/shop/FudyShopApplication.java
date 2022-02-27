package com.fudy.shop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@MapperScan("com.fudy.shop.infrastructure.db.mybatis.mapper")
public class FudyShopApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(FudyShopApplication.class, args);
		String[] beanDefinitionNames = context.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			System.out.println(beanDefinitionName);
		}
	}

}
