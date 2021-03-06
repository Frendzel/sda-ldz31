package pl.sda.chuck.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.sda.chuck.dto.ErrorResponse;

import javax.validation.ConstraintViolationException;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ExternalTechnicalException.class)
    public ResponseEntity<ErrorResponse> propagateExternalTechnicalException(ExternalTechnicalException e) {
        return new ResponseEntity<>(new ErrorResponse("Wrong Data"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> propagateConstraintException(ConstraintViolationException e) {
        return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> propagateIllegalArgumentException(ConstraintViolationException e) {
        return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> propagateException() {
        return new ResponseEntity<>(new ErrorResponse("UNKNOWN"), HttpStatus.BAD_REQUEST);
    }
}
