package com.ar.alexdev.cxfspringbootrs_CRUD;

import com.ar.alexdev.cxfspringbootrs_CRUD.models.Profession;
import com.ar.alexdev.cxfspringbootrs_CRUD.repositories.ProfessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class CxfSpringbootRSCrudApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(CxfSpringbootRSCrudApplication.class, args);
	}

	@Autowired
	ProfessionRepository professionRepository;

	@Override
	public void run(String... args) {
		List<Profession> professionDB = List.of(
				Profession.builder()
						.name("Backend Developer")
				.build(),
				Profession.builder()
						.name("Frontend Developer")
				.build(),
				Profession.builder()
						.name("Fullstack Developer")
				.build()
		);

		professionRepository.saveAll(professionDB);
	}
}
