package com.ar.alexdev.validatorspringboot.exception;

import com.ar.alexdev.validatorspringboot.dto.PROFESSION;
import com.ar.alexdev.validatorspringboot.utils.UserExceptionProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Stream;

@RestControllerAdvice
public class UserHandlerException {

    private final Map<String, String> errors = new HashMap<>();

    @Autowired
    UserExceptionProperties userExceptionProperties;



    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UserValidateException.class)
    public Map<String, String> badRequestException(UserValidateException validateException){
        validateException.getErrors()
                .forEach(e -> {
                    String field = e.getField();
                    errors.put(field, messageForField(field));
                });


        return errors;
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(UserAlreadyExistException.class)
    public String userExistException(UserAlreadyExistException ue){
        return ue.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Map<String, String> jsonException(HttpMessageNotReadableException jsonException){
        if(jsonException.getMessage().contains("Date"))
            errors.put("dateBirth", messageForField("dateBirth"));
        else
            errors.put("profession", messageForField("profession"));

        return errors;
    }


    private String messageForField(String fieldError){
        String message="";
        String professions = Stream.of(PROFESSION.values())
                                .map(PROFESSION::getValue)
                                .toList()
                                .toString();

        switch (fieldError){
            case "dni" -> message = userExceptionProperties.getUser().get("dni-message");
            case "name" -> message = userExceptionProperties.getUser().get("name-message");
            case "lastName" -> message = userExceptionProperties.getUser().get("lastName-message");
            case "email" -> message = userExceptionProperties.getUser().get("email-message");
            case "phone" -> message = userExceptionProperties.getUser().get("phone-message");
            case "dateBirth" -> message = userExceptionProperties.getUser().get("dateBirth-message");
            case "profession" -> message = userExceptionProperties.getUser().get("profession-message").concat(" ").concat(professions);
        }

        return message;
    }
}
