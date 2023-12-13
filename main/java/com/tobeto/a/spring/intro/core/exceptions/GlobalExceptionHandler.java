package com.tobeto.a.spring.intro.core.exceptions;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Configuration
@RestControllerAdvice //class içinde global exc. handler method bulunduğunu gösterir.
public class GlobalExceptionHandler {
    @ExceptionHandler({MethodArgumentNotValidException.class}) // methodun içerisinde verilen türün ex. handler metodu olduğunu belirler
    @ResponseStatus(HttpStatus.BAD_REQUEST) // return işlevinin cevabı hangi http statüsünde döndüreceğini belirler.
    public String handleValidationError(MethodArgumentNotValidException exception){
        return "Validasyon hatası";
    }

    @ExceptionHandler({RuntimeException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleRuntimeException(RuntimeException exception){
        return exception.getMessage();
    }

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleError(Exception exception)
    {
        return "Bilinmedik hata";
    }
}

