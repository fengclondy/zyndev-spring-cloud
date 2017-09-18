package com.zyndev.springbootsidecar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;

@EnableSidecar
@SpringBootApplication
public class SpringBootSidecarApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSidecarApplication.class, args);
	}
}
