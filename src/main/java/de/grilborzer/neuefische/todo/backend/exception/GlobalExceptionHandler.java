package de.grilborzer.neuefische.todo.backend.exception;

import de.grilborzer.neuefische.todo.backend.persistence.Todo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = TodoNotFoundException.class)
    public ResponseEntity handleTodoNotFoundException(TodoNotFoundException exception) {
        Map<String, Object> responseBody = new LinkedHashMap<>();

        responseBody.put("timestamp", LocalDateTime.now());
        responseBody.put("message", exception.getMessage());
        responseBody.put("exceptionType", "TodoNotFoundException");

        return new ResponseEntity<>(responseBody, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity handleRuntimeException(RuntimeException exception) {
        Map<String, Object> responseBody = new LinkedHashMap<>();

        responseBody.put("timestamp", LocalDateTime.now());
        responseBody.put("message", exception.getMessage());
        responseBody.put("exceptionType", "RuntimeException");

        return new ResponseEntity<>(responseBody, HttpStatus.NOT_FOUND);
    }

}
