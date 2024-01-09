package com.alexdev.springboot_CRUD;

import com.alexdev.springboot_CRUD.models.Profession;
import com.alexdev.springboot_CRUD.models.Role;
import com.alexdev.springboot_CRUD.models.User;
import com.alexdev.springboot_CRUD.repositories.IUserRepository;
import com.alexdev.springboot_CRUD.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringbootCrudApplication implements CommandLineRunner {
	public static void main(String[] args)  {
		SpringApplication.run(SpringbootCrudApplication.class, args);
	}

	@Autowired
	IUserRepository repository;
	@Autowired
	PasswordEncoder passwordEncoder;


	@Override
	public void run(String... args) throws Exception {
		User usrToSave = User.builder()
				.username("admin")
				.password(passwordEncoder.encode("admin"))
				.role(Role.builder()
						.id(1L)
						.name("Administrator").build())
				.profession(Profession.builder()
						.id(1L)
						.name("Backend Developer")
						.build())
				.build();

		repository.save(usrToSave);
	}
}