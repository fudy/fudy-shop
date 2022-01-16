package com.fudy.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class FudyShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(FudyShopApplication.class, args);
	}

}
