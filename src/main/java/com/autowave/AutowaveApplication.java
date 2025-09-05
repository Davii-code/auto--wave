package com.autowave;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication()
@EnableFeignClients
public class AutowaveApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutowaveApplication.class, args);
	}

}
