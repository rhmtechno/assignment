package com.rhmtech.ui.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StockUiApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockUiApplication.class, args);
	}

}
