package com.tinexlab.ms.spring_cloud_gateway;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringCloudGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudGatewayApplication.class, args);
	}

	@Bean
	public CommandLineRunner createPasswordsCommand(){
		return args -> {
			System.out.println("Spring Cloud Gateway");
			System.out.println("********************");
			System.out.println("Hola mundo! :)");
		};
	}


}
