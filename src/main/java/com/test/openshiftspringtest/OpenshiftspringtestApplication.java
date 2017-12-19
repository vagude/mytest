package com.test.openshiftspringtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@ComponentScan(basePackages="com.test")
public class OpenshiftspringtestApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenshiftspringtestApplication.class, args);
	}
}
