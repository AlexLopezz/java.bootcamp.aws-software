package com.ar.alexdev.validatorspringboot.services;

import com.ar.alexdev.validatorspringboot.exception.UserAlreadyExistException;
import com.ar.alexdev.validatorspringboot.exception.UserNotFoundException;
import com.ar.alexdev.validatorspringboot.utils.ExceptionMessage;
import com.ar.alexdev.validatorspringboot.dto.UserRequestPost;
import com.ar.alexdev.validatorspringboot.dto.UserRequestPut;
import com.ar.alexdev.validatorspringboot.exception.UserValidateException;
import com.ar.alexdev.validatorspringboot.exception.UserWithoutAnyValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;

import java.util.Optional;
import java.util.function.Function;

@Service
public class UserValidateService {
    @Autowired
    ExceptionMessage exceptionMessage;

    private final String dniToFound = "12345678";

    public void checkPost(UserRequestPost post,BindingResult errors){
        validateFields(errors);
        if(post.getDni().equals(dniToFound))
            throw new UserAlreadyExistException(exceptionMessage.messageAlreadyExist, dniToFound);

    }
    public void checkPut(UserRequestPut put, BindingResult errors){
        validateFields(errors);

        Optional.of(anyValue.apply(put))
                .filter(Boolean::booleanValue)
                .orElseThrow(() -> new UserWithoutAnyValueException(exceptionMessage.messageWithoutAnyValue));
    }

    public boolean checkUserExist(String dni){
        if(dni.equals(dniToFound))
            return true;
        else
            throw new UserNotFoundException(exceptionMessage.messageNotFound, dni);
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
