package com.alexdev.springBoot_CRUD.controller;

import com.alexdev.springBoot_CRUD.model.Profession;
import com.alexdev.springBoot_CRUD.model.User;
import com.alexdev.springBoot_CRUD.utils.JsonHandler;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.Date;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Sql(scripts = "/data-profession.sql")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTests {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    JsonHandler jsonHandler;

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
                .lastName("Sanchez")
                .dateBirth(new Date())
                .profession(Profession.builder().id(1L).name("Backend Developer").build())
                .build();
    }
    @BeforeEach
    void initEach() throws Exception {
        defaultSaveUser();
    }

    @DisplayName("ControllerTest: List all users.")
    @Test
    void getAllUsersControllerTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @DisplayName("ControllerTest: Save a new user.")
    @Test
    void saveUserControllerTest() throws Exception {
        User usrToSave = userByDefault;

        mockMvc.perform(MockMvcRequestBuilders.post("/users")
                        .content(jsonHandler.toJson(usrToSave))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @DisplayName("ControllerTest: Update existing user.")
    @Test
    void updateUser() throws Exception {
        User usrToUpdate = userByDefault;

        String newName= "Jose", newLastName="Perez";
        usrToUpdate.setName(newName);
        usrToUpdate.setLastName(newLastName);

        mockMvc.perform(MockMvcRequestBuilders.put("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonHandler.toJson(usrToUpdate)))
                .andDo(print())
                .andExpect(jsonPath("$.dni").exists())
                .andExpect(jsonPath("$.name").value(newName))
                .andExpect(jsonPath("$.lastName").value(newLastName))
                .andExpect(status().isOk());
    }

    @DisplayName("ControllerTest: Delete existing user")
    @Test
    void deleteUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/users/{dni}", userByDefault.getDni()))
                .andExpect(status().isOk());
    }

    @DisplayName("ControllerTest: Get a user")
    @Test
    void getUserFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{dni}", userByDefault.getDni())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.dni").value(userByDefault.getDni()));
    }



    void defaultSaveUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/users")
                        .content(jsonHandler.toJson(userByDefault))
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
    }
    /*
    @DisplayName("Check if save user w/ the same DNI")
    @Test
    void saveUserWithSameDNI() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(jsonHandler.toJson(userBuildDefault())))
                .andExpect(status().isConflict());
    }








    @DisplayName("Check if get user w/ DNI work correctly(user found)")
    @Test
    void getUserFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/{dni}", userBuildDefault().getDni())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.dni").value(userBuildDefault().getDni()));
    }
    @DisplayName("Check if get user w/ DNI work, correctly v2.0 (when user not found)")
    @Test
    void getUserNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/{dni}", "111111")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }



    */
}
