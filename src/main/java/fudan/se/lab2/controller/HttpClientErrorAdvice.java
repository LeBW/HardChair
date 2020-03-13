package fudan.se.lab2.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;

/**
 * @author LBW
 */
@ControllerAdvice
public class HttpClientErrorAdvice {
    @ResponseBody
    @ExceptionHandler(HttpClientErrorException.class)
    String badRequestHandler(HttpClientErrorException ex) {
        return ex.getMessage();
    }
}
