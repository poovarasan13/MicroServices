package com.kce.icecream_service;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients(basePackages = "com.kce.icecream_service.feignClient")
public class IcecreamServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(IcecreamServiceApplication.class, args);
	}

}
