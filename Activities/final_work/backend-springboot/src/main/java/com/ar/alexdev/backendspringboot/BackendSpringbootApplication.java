package com.ar.alexdev.backendspringboot;

import com.ar.alexdev.backendspringboot.models.Profession;
import com.ar.alexdev.backendspringboot.services.ProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class BackendSpringbootApplication implements CommandLineRunner {
	@Autowired
	ProfessionService professionService;

	public static void main(String[] args) {
		SpringApplication.run(BackendSpringbootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Profession> professions =	List.of(
				Profession.builder()
					.name("Backend Developer")
					.build(),
				Profession.builder()
							.name("Frontend Developer")
							.build(),
				Profession.builder()
							.name("Fullstack Developer")
							.build(),
				Profession.builder()
							.name("Tester QA")
							.build()
		);

		professionService.saveAll(professions);
	}
}