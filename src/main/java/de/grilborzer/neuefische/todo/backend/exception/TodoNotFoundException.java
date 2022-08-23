package de.grilborzer.neuefische.todo.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class TodoNotFoundException extends RuntimeException {


    public TodoNotFoundException(String todoId) {
        // We use a more expressive constructor to disable the stack trace
        // "Constructs a new runtime exception with the specified detail message, cause, suppression enabled or disabled, and writable stack trace enabled or disabled. "
        // Docs: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/RuntimeException.html
        super("Todo with ID " + todoId + " does not exist!", null, false, false);
    }
}
