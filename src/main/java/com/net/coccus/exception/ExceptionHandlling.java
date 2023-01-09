package com.net.coccus.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;


@RestControllerAdvice
@Slf4j
public class ExceptionHandlling  implements ErrorController {

    private ResponseEntity<HttpResponse> createHttpResponse(HttpStatus status, String messsage){

        HttpResponse httpResponse = HttpResponse.builder()
                .httpStatus(status)
                .httpStatusCode(status.value())
                .reason(status.getReasonPhrase().toUpperCase())
                .message(messsage.toUpperCase())
                .build();

        return new ResponseEntity<>(httpResponse,status);

    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody ResponseEntity<HttpResponse> handleNoMethodException(HttpServletRequest request,
                                                          NoHandlerFoundException ex) {
        return this.createHttpResponse(HttpStatus.INTERNAL_SERVER_ERROR, "ERROR_PROCESSING_FIL");
    }

    @ExceptionHandler(Throwable.class)
    public @ResponseBody ResponseEntity<HttpResponse> handleDefaultException(Throwable ex) {
        return this.createHttpResponse(HttpStatus.INTERNAL_SERVER_ERROR, "INVALID REQUEST ");
    }

}
