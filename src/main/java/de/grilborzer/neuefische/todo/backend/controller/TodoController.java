package de.grilborzer.neuefische.todo.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = {"/todos"})
public class TodoController {

    @GetMapping
    public ResponseEntity getAllTodos() {
        return ResponseEntity.ok().build();
    }
}
