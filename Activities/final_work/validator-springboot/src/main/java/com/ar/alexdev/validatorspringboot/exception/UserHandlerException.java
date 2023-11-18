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
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

@RestControllerAdvice
public class UserHandlerException {
    @Autowired
    UserExceptionProperties userExceptionProperties;


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value= {UserValidateException.class, HttpMessageNotReadableException.class})
    public Map<String, String> badRequestException(RuntimeException exception){
        Map<String, String> err = new LinkedHashMap<>();
        if(exception instanceof UserValidateException validateException) {
            validateException.getErrors()
                    .forEach(e -> {
                        String field = e.getField();
                        err.put(field, messageForField(field));
                    });
        }

        if(exception instanceof HttpMessageNotReadableException jsonException){
            if(jsonException.getMessage().contains("Date"))
                err.put("dateBirth", messageForField("dateBirth"));
            else
                err.put("profession", messageForField("profession"));
        }

        return err;
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(UserAlreadyExistException.class)
    public String userExistException(UserAlreadyExistException ue){
        return ue.getMessage();
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
