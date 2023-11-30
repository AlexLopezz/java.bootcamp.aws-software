package com.ar.alexdev.backendspringboot.repositories;

import com.ar.alexdev.backendspringboot.models.Profession;
import com.ar.alexdev.backendspringboot.models.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;

@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    void saveUserTest(){
        User userToSave = User.builder()
                .dni("12345678")
                .name("Alex")
                .lastName("Lopez")
                .profession(Profession.builder()
                        .name("Backend Developer")
                        .build())
                .dateBirth(new Date())
                .phone("+54 3625 678976")
                .email("asdasd@gmail.com")
                .build();

        User userSaved = userRepository.save(userToSave);

        Assertions.assertThat(userSaved).isNotNull();
    }
}
