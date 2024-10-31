package com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"model"})
@EnableJpaRepositories("repository")
public class IetriMangoldtPalmierApplication {

	public static void main(String[] args) {
		SpringApplication.run(IetriMangoldtPalmierApplication.class, args);
	}

}
