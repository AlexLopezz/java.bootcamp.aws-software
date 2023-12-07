package com.alexdev.springboot_CRUD;

import com.alexdev.springboot_CRUD.models.Profession;
import com.alexdev.springboot_CRUD.services.IProfessionService;
import com.alexdev.springboot_CRUD.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringbootCrudApplication implements CommandLineRunner {
	@Autowired
	IProfessionService profService;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*Add records for Entity Professions before starter SpringApp:
		List<Profession> professions = List
				.of(
						Profession.builder().name("Backend Developer").build(),
						Profession.builder().name("Frontend Developer").build(),
						Profession.builder().name("Fullstack Developer").build(),
						Profession.builder().name("QA Developer").build()
				);

		profService.saveAll(professions); */
	}
}
