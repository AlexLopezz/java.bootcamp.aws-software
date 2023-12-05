package com.ar.alexdev.cxfspringbootws_CRUD;

import com.ar.alexdev.cxfspringbootws_CRUD.models.Profession;
import com.ar.alexdev.cxfspringbootws_CRUD.repositories.ProfessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class CxfSpringbootWsCrudApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(CxfSpringbootWsCrudApplication.class, args);
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
