package com.api.beelieve;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.api.beelieve.repositorio.DataRepositorio;



@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.api.beelieve.repositorio")
public class BeelieveApplication {
	
	@Autowired
	private DataRepositorio data_repositorio;
	
	public static void main(String[] args) {
		
		
		SpringApplication.run(BeelieveApplication.class, args);
	}

}
