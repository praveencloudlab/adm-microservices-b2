package com.cts.ecart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication // auto discover
public class Application { // container

	public static void main(String[] args) {
		SpringApplication.run(Application.class,args);
	}

}
