package com.alexdev.springBoot_CRUD.repository;

import com.alexdev.springBoot_CRUD.model.Profession;
import com.alexdev.springBoot_CRUD.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@Sql(scripts = "/data-profession.sql")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class UserRepositoryTests {
    @Autowired
    IUserRepository repository;

    static User userByDefault;
    static List<User> usersByDefault;

    @BeforeAll
    static void init(){
        usersByDefault =  List.of(
                User.builder()
                        .dni("12365432")
                        .name("Javier")
                        .lastName("Hernandez")
                        .dateBirth(new Date())
                        .profession(Profession.builder().id(1L).build())
                        .build(),
                User.builder()
                        .dni("34527680")
                        .name("Pedro")
                        .lastName("Valenzuela")
                        .dateBirth(new Date())
                        .profession(Profession.builder().id(2L).build())
                        .build(),
                User.builder()
                        .dni("99887766")
                        .name("Gabriel")
                        .lastName("Zapata")
                        .dateBirth(new Date())
                        .profession(Profession.builder().id(3L).build())
                        .build()
        );

        userByDefault = User.builder()
                .dni("87654321")
                .name("Daniel")
                .lastName("Juan Perez")
                .dateBirth(new Date())
                .profession(Profession.builder().id(1L).build())
                .build();
    }

    @DisplayName("RepositoryTest: List all users.")
    @Test
    void testListAllUser(){
        //given - precondition
        List<User> usersToSave = usersByDefault;

        //when - action or behavior
        List<User> usersSaved = repository.saveAll(usersToSave);

        //then - check action
        assertThat(usersSaved).isNotNull();
        Assertions.assertFalse(usersSaved.isEmpty());
    }

    @DisplayName("RepositoryTest: Save a new user.")
    @Test
    void testSaveUser(){
        //given
        User usrToSave = userByDefault;

        //when - action or behavior
        User usrSaved = repository.save(usrToSave);

        //then - check action.
        assertThat(usrSaved).isNotNull();
    }

    @DisplayName("RepositoryTest: Update a existing user")
    @Test
    void testUpdateUser(){
        //given
        User usrSaved = saveUserDefault();

        String newName ="Jorge" , newLastName= "Sanchez";
        Long idNewProfession = 3L;

        usrSaved.setName(newName);
        usrSaved.setLastName(newLastName);
        usrSaved.setProfession(Profession.builder().id(idNewProfession).build());

        //when - action or behavior
        User usrUpdated = repository.save(usrSaved);

        //then - check action.
        assertThat(usrUpdated).isNotNull();
        Assertions.assertEquals(newName, usrUpdated.getName());
        Assertions.assertEquals(newLastName, usrUpdated.getLastName());
        assertThat(usrUpdated.getProfession().getId()).isGreaterThan(0L);
        Assertions.assertEquals(idNewProfession, usrUpdated.getProfession().getId());
    }

    @DisplayName("RepositoryTest: Get a user")
    @Test
    void testGetUserById(){
        //given
        saveUserDefault();
        String dniUsrToSearch = userByDefault.getDni();

        //when - action or behavior
        Optional<User> usrFound = repository.findById(dniUsrToSearch);

        //then - check action.
        assertThat(usrFound).isNotEmpty();
    }

    @DisplayName("RepositoryTest: Delete existing user")
    @Test
    void testDeleteUser(){
        //given - precondition
        String dniUsrSaved = saveUserDefault().getDni();

        //when - action or behavior
        repository.deleteById(dniUsrSaved);

        //then - check action
        Assertions.assertEquals(repository.findById(dniUsrSaved), Optional.empty());
        Assertions.assertTrue(repository.findAll().isEmpty());
    }



    User saveUserDefault(){
        return repository.save(userByDefault);
    }
}