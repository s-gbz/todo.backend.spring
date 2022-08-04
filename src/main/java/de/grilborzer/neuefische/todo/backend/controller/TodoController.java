package de.grilborzer.neuefische.todo.backend.controller;

import de.grilborzer.neuefische.todo.backend.persistence.Todo;
import de.grilborzer.neuefische.todo.backend.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = {"/v1/todos"})
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

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
    @PostMapping(value = "/save")
    public String saveTodo(@RequestBody Todo todo) {
        return todoService.saveTodo(todo);
    }
}
