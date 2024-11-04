package pl.edu.pjatk.MPR_Projekt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class PiesekExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler (value = {PiesekNotFoundException.class})
    public ResponseEntity<Object> handlePiesekNotFound(RuntimeException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler (value = {PiesekAlreadyExistException.class})
    public ResponseEntity<Object> handlePiesekAlreadyExist(RuntimeException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
