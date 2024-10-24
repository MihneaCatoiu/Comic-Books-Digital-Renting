package com.itschool.ComicBooksDigitalRenting.exceptions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Slf4j
@ControllerAdvice
public class ExceptionHandlerAdvice {

    private final ObjectMapper objectMapper;

    public ExceptionHandlerAdvice(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @ExceptionHandler(ComicBookNotFoundException.class)
    public ResponseEntity<String> bookNotFoundException(ComicBookNotFoundException bookNotFoundException) {
        return new ResponseEntity<>(objectToString(Map.of("message", bookNotFoundException.getMessage())), NOT_FOUND);
    }


    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<String> customerDeleteException(CustomerNotFoundException customerNotFoundException) {
        return new ResponseEntity<>(objectToString(Map.of("message", customerNotFoundException.getMessage())), NOT_FOUND);
    }

    @ExceptionHandler(CustomerDuplicateEmailException.class)
    public ResponseEntity<String> customerDuplicateEmailException(CustomerDuplicateEmailException customerDuplicateEmailException) {
        return new ResponseEntity<>(objectToString(Map.of("message", customerDuplicateEmailException.getMessage())), NOT_FOUND);
    }

    private String objectToString(Object response) {
        try {
            return objectMapper.writeValueAsString(response);
        } catch (JsonProcessingException e) {
            log.error("Error processing response to string");
            return "Internal error";
        }
    }
}
