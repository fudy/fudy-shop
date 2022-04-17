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
		SpringApplication.run(FudyShopApplication.class, args);
	}

}
