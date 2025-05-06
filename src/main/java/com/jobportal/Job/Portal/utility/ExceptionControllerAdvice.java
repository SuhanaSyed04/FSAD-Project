package com.jobportal.Job.Portal.utility;

import com.jobportal.Job.Portal.exception.JobPortalException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @Autowired
    private Environment environment;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorInfo> generalException(Exception exception) {
        ErrorInfo errorInfo = new ErrorInfo(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                exception.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorInfo, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(JobPortalException.class)
    public ResponseEntity<ErrorInfo> generalException(JobPortalException exception) {
        String message = environment.getProperty(exception.getMessage());
        ErrorInfo errorInfo = new ErrorInfo(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                message,
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorInfo, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class, ConstraintViolationException.class})
    public ResponseEntity<ErrorInfo> handleValidationExceptions(Exception exception) {
        String msg;

        if (exception instanceof MethodArgumentNotValidException methodArgumentNotValidException) {
            msg = methodArgumentNotValidException.getBindingResult().getAllErrors()
                    .stream()
                    .map(error -> error.getDefaultMessage())
                    .collect(Collectors.joining(", "));
        } else if (exception instanceof ConstraintViolationException constraintViolationException) {
            msg = constraintViolationException.getConstraintViolations()
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.joining(", "));
        } else {
            msg = "Validation error occurred";
        }

        ErrorInfo errorInfo = new ErrorInfo(
                HttpStatus.BAD_REQUEST.value(),
                msg,
                LocalDateTime.now()
        );

        return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
    }
}
