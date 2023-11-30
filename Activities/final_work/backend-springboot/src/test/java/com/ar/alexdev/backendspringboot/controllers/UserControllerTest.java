package com.ar.alexdev.backendspringboot.controllers;

import com.ar.alexdev.backendspringboot.models.dto.UserDTO;
import com.ar.alexdev.backendspringboot.utils.JsonHandler;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.ar.alexdev.backendspringboot.utils.UserUtils.userBuildDefault;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class) //This for order test(@Order)
@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {
    @Autowired
    JsonHandler jsonHandler;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void init() throws Exception {
        defaultSaveUser();
    }

    @Order(1)
    @DisplayName("Check if get All users work")
    @Test
    void getAllUsers() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    @Order(2)
    @DisplayName("Check if get All users, works when there are no users")
    @Test
    void getAllUsersWithNotUsers() throws Exception {
        deleteUser();
        mockMvc.perform(MockMvcRequestBuilders.get("/user")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }


    @DisplayName("Check if save user correctly")
    @Test
    void saveUser() throws Exception {
        UserDTO dtoSave = userBuildDefault();
        dtoSave.setDni("12345678");

        mockMvc.perform(MockMvcRequestBuilders.post("/user")
                .content(jsonHandler.toJson(dtoSave))
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated());

        deleteUser();
    }

    @DisplayName("Check if save user w/ the same DNI")
    @Test
    void saveUserWithSameDNI() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(jsonHandler.toJson(userBuildDefault())))
                .andExpect(status().isConflict());
    }


    @DisplayName("Check if update user correctly.")
    @Test
    void updateUser() throws Exception {
        UserDTO dto = userBuildDefault();
        dto.setName("Pepito");
        dto.setLastName("Perez");

        mockMvc.perform(MockMvcRequestBuilders.put("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonHandler.toJson(dto)))
                .andExpect(status().isOk());
    }


    @DisplayName("Check if delete user correctly.")
    @Test
    void deleteUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/user/{dni}", userBuildDefault().getDni()))
                .andExpect(status().isOk());
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



    void defaultSaveUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/user")
                        .content(jsonHandler.toJson(userBuildDefault()))
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
    }

}