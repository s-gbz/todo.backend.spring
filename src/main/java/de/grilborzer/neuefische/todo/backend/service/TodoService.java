package de.grilborzer.neuefische.todo.backend.service;

import de.grilborzer.neuefische.todo.backend.persistence.Todo;
import de.grilborzer.neuefische.todo.backend.persistence.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public String saveTodo(Todo todo) {
        return todoRepository.save(todo).id;
    }

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

}
