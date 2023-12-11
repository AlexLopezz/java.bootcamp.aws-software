package com.ar.alexdev.backendspringboot.exception;

import com.ar.alexdev.backendspringboot.config.MessageException;
import com.ar.alexdev.backendspringboot.exception.response.ErrorResponse;
import com.ar.alexdev.backendspringboot.exception.user.AlreadyExistException;
import com.ar.alexdev.backendspringboot.exception.user.NoContentException;
import com.ar.alexdev.backendspringboot.exception.user.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserHandlerException {
    @Autowired
    MessageException messageException;


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ErrorResponse notFoundUser(NotFoundException e){
        return ErrorResponse.builder()
                    .message(String.format(messageException
                            .userNotFound, e.getMessage()))
                .build();
    }
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(AlreadyExistException.class)
    public ErrorResponse alreadyExistUser(AlreadyExistException e){
        return ErrorResponse.builder()
                .message(String.format(
                        messageException
                                .userAlreadyExist, e.getMessage()))
                .build();
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ExceptionHandler(NoContentException.class)
    public void noContentUser(){ }
}
