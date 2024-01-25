package com.tinexlab.ms.empresa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
public class EmpresaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpresaApplication.class, args);
	}

	@Bean
	public CommandLineRunner createPasswordsCommand(){
		return args -> {
			System.out.println("Empresas - microservicio");
			System.out.println("************************");
			System.out.println("Hola mundo! :)");
		};
	}

}
