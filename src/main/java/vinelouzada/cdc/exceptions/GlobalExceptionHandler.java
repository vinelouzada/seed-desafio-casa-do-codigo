package vinelouzada.cdc.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({EmailAlreadyExistsException.class})
    public ResponseEntity<ExceptionDetails> handleEmailAlreadyExistsException(EmailAlreadyExistsException e) {
        ExceptionDetails exceptionDetails = new ExceptionDetails(e.getMessage(), HttpStatus.BAD_REQUEST);
        return ResponseEntity.status(exceptionDetails.httpStatus()).body(exceptionDetails);
    }
}
