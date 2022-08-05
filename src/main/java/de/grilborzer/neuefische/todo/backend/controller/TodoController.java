package de.grilborzer.neuefische.todo.backend.controller;

import de.grilborzer.neuefische.todo.backend.persistence.Todo;
import de.grilborzer.neuefische.todo.backend.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }

    // Should we have separate methods to create and update entities? A tough choice for sure!
    // I'm going for a uniform save method since this use case is rather ordinary and
    // hasn't specified any constraints in controller response.
    // There's also no tangible benefit in splitting the two.
    //
    // We do "sacrifice" not having a proper PUT verb, but we'll accept that for now.
    @PostMapping
    public String saveTodo(@RequestBody Todo todo) {
        return todoService.saveTodo(todo);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity.BodyBuilder deleteTodo(@PathVariable String todoId) {
        todoService.deleteTodo(todoId);
        return ResponseEntity.ok();
    }
}
