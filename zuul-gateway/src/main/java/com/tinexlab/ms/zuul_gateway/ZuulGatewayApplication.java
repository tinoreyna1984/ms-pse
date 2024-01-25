package com.tinexlab.ms.zuul_gateway;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@EnableZuulProxy
@SpringBootApplication
public class ZuulGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulGatewayApplication.class, args);
	}

	@Bean
	public CommandLineRunner createPasswordsCommand(){
		return args -> {
			System.out.println("Servidor Zuul");
			System.out.println("*************");
			System.out.println("Hola mundo! :)");
		};
	}

}
