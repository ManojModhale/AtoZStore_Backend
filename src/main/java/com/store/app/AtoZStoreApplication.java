package com.store.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan( basePackages = {"com.store.app.service", "com.store.app.controller", "com.store.app.dao"})
public class AtoZStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtoZStoreApplication.class, args);
	}

}
