package com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.model.Camion;
import com.desi.IetriMangoldtPalmier.IetriMangoldtPalmier.repository.CamionRepository;

@SpringBootApplication
public class IetriMangoldtPalmierApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(IetriMangoldtPalmierApplication.class, args);
	}
	
	@Autowired
	private CamionRepository camionRepository;

	@Override
	public void run(String... args) throws Exception {
		
		/*
		Camion camion = new Camion ("12345", "Ford", "2005", "Rosario");
		camionRepository.save(camion);
		
		Camion camion2 = new Camion ("12346", "Iveco", "2012", "Santa Fe");
		camionRepository.save(camion2);
		
		*/
		
	
	}
	
	

}
