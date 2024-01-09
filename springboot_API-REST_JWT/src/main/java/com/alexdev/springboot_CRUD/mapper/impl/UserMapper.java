package com.alexdev.springboot_CRUD.mapper.impl;

import com.alexdev.springboot_CRUD.mapper.IUserMapper;
import com.alexdev.springboot_CRUD.models.Profession;
import com.alexdev.springboot_CRUD.models.Role;
import com.alexdev.springboot_CRUD.models.User;
import com.alexdev.springboot_CRUD.models.dto.UserRequest;
import com.alexdev.springboot_CRUD.models.dto.UserResponse;
import com.alexdev.springboot_CRUD.repositories.IProfessionRepository;
import com.alexdev.springboot_CRUD.repositories.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements IUserMapper<User, UserRequest, UserResponse> {
    private final IRoleRepository roleRepository;
    private final IProfessionRepository professionRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserMapper(IRoleRepository roleRepository,
                      IProfessionRepository professionRepository,
                      PasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.professionRepository = professionRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User fromReqToEntity(UserRequest userRequest) {
         return User.builder()
                 .id(userRequest.getId()!=null? userRequest.getId() : null)
                 .username(userRequest.getUsername())
                 .password(passwordEncoder.encode(userRequest.getPassword()))
                 .role(roleFindByName(userRequest.getRole()))
                 .profession(professionFindByName(userRequest.getProfession()))
                 .build();
    }

    @Override
    public User fromRespToEntity(UserResponse userResponse) {
        return User.builder()
                .id(userResponse.getId())
                .username(userResponse.getUsername())
                .role(roleFindByName(userResponse.getRole()))
                .profession(professionFindByName(userResponse.getProfession()))
                .build();
    }
    @Override
    public UserResponse fromEntityToResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .role(user.getRole().getName())
                .profession(user.getProfession().getName())
                .build();
    }

    private Role roleFindByName(String name){ return roleRepository.findByName(name).orElseThrow(); }
    private Profession professionFindByName(String name){ return professionRepository.findByName(name).orElseThrow(); }
}