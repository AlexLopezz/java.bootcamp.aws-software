package com.ar.alexdev.validatorspringboot.services;

import com.ar.alexdev.validatorspringboot.exception.UserAlreadyExistException;
import com.ar.alexdev.validatorspringboot.exception.UserNotFoundException;
import com.ar.alexdev.validatorspringboot.utils.ExceptionMessage;
import com.ar.alexdev.validatorspringboot.request.UserRequestPost;
import com.ar.alexdev.validatorspringboot.request.UserRequestPut;
import com.ar.alexdev.validatorspringboot.exception.UserValidateException;
import com.ar.alexdev.validatorspringboot.exception.UserWithoutAnyValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Service
public class UserValidateService {
    @Autowired
    RestTemplate restTemplate;


    public void checkPost(UserRequestPost post,BindingResult errors){
        validateFields(errors);
        if(checkUserExist(post.getDni()))
            throw new UserAlreadyExistException(post.getDni());
    }
    public void checkPut(UserRequestPut put, BindingResult errors){
        validateFields(errors);

        if(!checkUserExist(put.getDni()))
            throw new UserNotFoundException(put.getDni());

        Optional.of(anyValue.apply(put))
                .filter(Boolean::booleanValue)
                .orElseThrow(UserWithoutAnyValueException::new);
    }

    public boolean checkUserExist(String dni){
        return userExist.apply(dni);
    }

    private void validateFields(BindingResult errors){
        Optional.of(errors)
                .filter(Errors::hasErrors)
                .ifPresent(e -> {
                    throw new UserValidateException(errors.getFieldErrors());
                });
    }
    private final Function<UserRequestPut, Boolean> anyValue = u -> u.getName()!= null
            || u.getLastName() != null || u.getEmail() != null || u.getPhone()!= null
            || u.getProfession() != null || u.getDateBirth() != null;

    private final Function<String, Boolean> userExist = u ->{
        try {
            ResponseEntity<String> response
                    = restTemplate.getForEntity("http://localhost:8080/user/".concat(u), String.class);

            return response.getStatusCode().is2xxSuccessful();
        }catch (HttpClientErrorException ignored){
            return false;
        }
    };
}
