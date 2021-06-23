package com.vm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;





@SpringBootApplication
@ComponentScan(basePackages = "com.vm")


public class SpringrestdatajpademoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringrestdatajpademoApplication.class, args);
	}

}
