package com.zyndev.springbootconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class SpringBootConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootConfigApplication.class, args);
	}
}
