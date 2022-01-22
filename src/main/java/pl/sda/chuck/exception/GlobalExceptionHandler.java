package pl.sda.chuck.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.sda.chuck.dto.ErrorResponse;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ExternalTechnicalException.class)
    public ResponseEntity<ErrorResponse> propagateExternalTechnicalException(ExternalTechnicalException e) {
        return new ResponseEntity<>(new ErrorResponse("Unknown joke"), HttpStatus.NOT_FOUND);
    }
}
