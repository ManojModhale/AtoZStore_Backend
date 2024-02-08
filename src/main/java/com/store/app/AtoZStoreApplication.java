package com.store.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.store.app.*")
public class AtoZStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtoZStoreApplication.class, args);
	}

}
