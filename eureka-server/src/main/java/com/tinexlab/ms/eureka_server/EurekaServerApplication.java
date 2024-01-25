package com.tinexlab.ms.eureka_server;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication.class, args);
	}

	@Bean
	public CommandLineRunner createPasswordsCommand(){
		return args -> {
			System.out.println("Eureka Server");
			System.out.println("*************");
			System.out.println("Hola mundo! :)");
		};
	}

}
