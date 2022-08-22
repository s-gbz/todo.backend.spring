package de.grilborzer.neuefische.todo.backend.controller;

import de.grilborzer.neuefische.todo.backend.persistence.Todo;
import de.grilborzer.neuefische.todo.backend.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping(value = {"/{todoId}"})
    public Todo getTodo(@PathVariable String todoId) {
        return todoService.getTodo(todoId);
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
