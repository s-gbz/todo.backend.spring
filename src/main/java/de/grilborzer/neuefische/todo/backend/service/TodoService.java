package de.grilborzer.neuefische.todo.backend.service;

import de.grilborzer.neuefische.todo.backend.persistence.Todo;
import de.grilborzer.neuefische.todo.backend.persistence.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public String saveTodo(Todo todo) {
        return todoRepository.save(todo).getId();
    }

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

}
