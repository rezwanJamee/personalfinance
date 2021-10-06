package com.rifatsproject.Personalfinance.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class UserInputException extends RuntimeException {
    public UserInputException(String message){
        super(message);
    }
}
