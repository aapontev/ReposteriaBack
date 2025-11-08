package com.reposteria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RecetasServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(RecetasServiceApplication.class, args);
	}
}