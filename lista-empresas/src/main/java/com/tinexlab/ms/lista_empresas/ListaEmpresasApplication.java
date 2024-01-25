package com.tinexlab.ms.lista_empresas;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@ImportAutoConfiguration({FeignAutoConfiguration.class}) // probar
public class ListaEmpresasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ListaEmpresasApplication.class, args);
	}

	@Bean
	public CommandLineRunner createPasswordsCommand(){
		return args -> {
			System.out.println("Lista de empresas - microservicio");
			System.out.println("*********************************");
			System.out.println("Hola mundo! :)");
		};
	}
}
