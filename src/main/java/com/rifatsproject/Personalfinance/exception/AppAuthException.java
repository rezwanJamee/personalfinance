package com.rifatsproject.Personalfinance.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class AppAuthException extends RuntimeException {

    public AppAuthException(String message){ super(message);}
}
