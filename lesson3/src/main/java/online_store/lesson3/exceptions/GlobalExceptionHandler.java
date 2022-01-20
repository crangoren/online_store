package online_store.lesson2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<online_store.lesson2.exceptions.AppError> catchResourceNotFoundException(online_store.lesson2.exceptions.ResourceNotFoundException  e) {
        return new ResponseEntity<>(new online_store.lesson2.exceptions.AppError (HttpStatus.NOT_FOUND.value(), e.getMessage()), HttpStatus.NOT_FOUND);
    }
}