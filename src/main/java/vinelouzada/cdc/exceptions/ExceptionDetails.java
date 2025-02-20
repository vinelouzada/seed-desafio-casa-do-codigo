package vinelouzada.cdc.exceptions;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ExceptionDetails(String message, HttpStatus httpStatus, int httpStatusCode, LocalDateTime time) {
    public ExceptionDetails(String message, HttpStatus httpStatus) {
        this(message, httpStatus, httpStatus.value(), LocalDateTime.now());
    }
}