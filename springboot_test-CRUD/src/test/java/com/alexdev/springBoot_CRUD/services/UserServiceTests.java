package com.alexdev.springBoot_CRUD.services;

import com.alexdev.springBoot_CRUD.model.Profession;
import com.alexdev.springBoot_CRUD.model.User;
import com.alexdev.springBoot_CRUD.repository.IUserRepository;
import com.alexdev.springBoot_CRUD.services.impl.UserService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class UserServiceTests {

    @Mock
    IUserRepository repository;

    @InjectMocks
    UserService service;

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
                .profession(Profession.builder().id(1L).name("Backend Developer").build())
                .build();
    }

    @DisplayName("ServiceTest: List all users.")
    @Test
    void testListAllUserService(){
        //given
        given(repository.findAll()).willReturn(usersByDefault);
        //when
        List<User> users = service.getAll();
        //then
        verify(repository, times(1)).findAll();
        assertFalse(users.isEmpty());
        assertEquals(3, users.size());
    }

    @DisplayName("ServiceTest: Save a new user.")
    @Test
    void testSaveUserService(){
        //given
        given(repository.save(userByDefault)).willReturn(userByDefault);
        //when
        User userSaved = service.save(userByDefault);

        //then
        assertThat(userSaved).isNotNull();
        assertEquals(userSaved.getDni(), userByDefault.getDni());
    }

    @DisplayName("ServiceTest: Get a user")
    @Test
    void testGetByIdUserService(){
        //given
        given(repository.findById(userByDefault.getDni())).willReturn(Optional.of(userByDefault));

        //when
        Optional<User> userFound = service.getBy(userByDefault.getDni());

        //then
        assertNotNull(userFound);
        assertTrue(userFound.isPresent());
    }

    @DisplayName("ServiceTest: Update existing user.")
    @Test
    void testUpdateUserService(){
        given(repository.save(userByDefault)).willReturn(userByDefault);

        String newName = "Alex", newLastName= "Lopez";
        userByDefault.setName(newName);
        userByDefault.setLastName(newLastName);

        User usrUpdated = repository.save(userByDefault);

        assertNotNull(usrUpdated);
        assertEquals(newName, usrUpdated.getName());
        assertEquals(newLastName, usrUpdated.getLastName());
    }

    @DisplayName("ServiceTest: Delete existing user")
    @Test
    void testDeleteUserService(){
        //given
        String dniUserToDelete = userByDefault.getDni();

        //when
        service.delete(dniUserToDelete);

        //then
        verify(repository, times(1)).deleteById(dniUserToDelete);
    }

}
