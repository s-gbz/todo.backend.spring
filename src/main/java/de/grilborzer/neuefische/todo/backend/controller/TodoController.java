package de.grilborzer.neuefische.todo.backend.controller;

import de.grilborzer.neuefische.todo.backend.exception.TodoNotFoundException;
import de.grilborzer.neuefische.todo.backend.persistence.Todo;
import de.grilborzer.neuefische.todo.backend.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/v1/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping(value = {"/{todoId}"})
    public ResponseEntity getTodo(@PathVariable String todoId) {
        try {
            Todo todo = todoService.getTodo(todoId);

            return new ResponseEntity<>(todo, HttpStatus.OK);
        } catch (TodoNotFoundException exception) {
            Map<String, Object> responseBody = new LinkedHashMap<>();

            responseBody.put("timestamp", LocalDateTime.now());
            responseBody.put("message", exception.getMessage());

            return new ResponseEntity<>(responseBody, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }

    @PostMapping
    public String saveTodo(@RequestBody Todo todo) {
        return todoService.createTodo(todo);
    }

    @PutMapping(value = "/{todoId}")
    public void updateTodo(@PathVariable String todoId, @RequestBody Todo updatedTodo) {
        todoService.updateTodo(todoId, updatedTodo);
    }

    @DeleteMapping(value = "/{todoId}")
    public void deleteTodo(@PathVariable String todoId) {
        todoService.deleteTodo(todoId);
    }
}
