package com.ar.alexdev.validatorspringboot.services;

import com.ar.alexdev.validatorspringboot.exception.UserAlreadyExistException;
import com.ar.alexdev.validatorspringboot.exception.UserNotFoundException;
import com.ar.alexdev.validatorspringboot.utils.ExceptionMessage;
import com.ar.alexdev.validatorspringboot.dto.UserRequestPost;
import com.ar.alexdev.validatorspringboot.dto.UserRequestPut;
import com.ar.alexdev.validatorspringboot.exception.UserValidateException;
import com.ar.alexdev.validatorspringboot.exception.UserWithoutAnyValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
import java.util.function.Function;

@Service
public class UserValidateService {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ExceptionMessage exceptionMessage;


    public String checkPost(UserRequestPost post,BindingResult errors){
        validateFields(errors);

        ResponseEntity<String> response
                = restTemplate.getForEntity("http://localhost:8080/user/".concat(post.getDni()), String.class);
        if(response.getStatusCode() == HttpStatusCode.valueOf(200))
            return String.format(exceptionMessage.messageAlreadyExist, post.getDni());
        else
            throw new UserAlreadyExistException(exceptionMessage.messageAlreadyExist, post.getDni());

    }
    public void checkPut(UserRequestPut put, BindingResult errors){
        validateFields(errors);

        Optional.of(anyValue.apply(put))
                .filter(Boolean::booleanValue)
                .orElseThrow(() -> new UserWithoutAnyValueException(exceptionMessage.messageWithoutAnyValue));
    }

    public String checkUserExist(String dni){
        ResponseEntity<String> response
                = restTemplate.getForEntity("http://localhost:8080/user/".concat(dni), String.class);

        if(response.getStatusCode() == HttpStatusCode.valueOf(200))
            return String.format(exceptionMessage.messageAlreadyExist, dni);
        else
            return String.format(exceptionMessage.messageNotFound, dni);
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
}
