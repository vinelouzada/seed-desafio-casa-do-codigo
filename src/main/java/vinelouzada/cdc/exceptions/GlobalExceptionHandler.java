package vinelouzada.cdc.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({EmailAlreadyExistsException.class, NameAlreadyExistsException.class})
    public ResponseEntity<ExceptionDetails> handleEmailAlreadyExistsException(Exception e) {
        ExceptionDetails exceptionDetails = new ExceptionDetails(e.getMessage(), HttpStatus.BAD_REQUEST);
        return ResponseEntity.status(exceptionDetails.httpStatus()).body(exceptionDetails);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<FormExceptionDetails>> handleArgumentNotValidException(MethodArgumentNotValidException e) {
        List<FormExceptionDetails> formExceptionDetails = e.getFieldErrors().stream().map(FormExceptionDetails::new).toList();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(formExceptionDetails);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ExceptionDetails> handleEntityNotFoundException(EntityNotFoundException e) {
        ExceptionDetails exceptionDetails = new ExceptionDetails(e.getMessage(), HttpStatus.NOT_FOUND);
        return ResponseEntity.status(exceptionDetails.httpStatus()).body(exceptionDetails);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ExceptionDetails> handleIllegalArgumentException(IllegalArgumentException e) {
        ExceptionDetails exceptionDetails = new ExceptionDetails(e.getMessage(), HttpStatus.BAD_REQUEST);
        return ResponseEntity.status(exceptionDetails.httpStatus()).body(exceptionDetails);
    }
}
