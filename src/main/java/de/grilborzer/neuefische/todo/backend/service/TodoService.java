package de.grilborzer.neuefische.todo.backend.service;

import de.grilborzer.neuefische.todo.backend.persistence.Todo;
import de.grilborzer.neuefische.todo.backend.persistence.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public String createTodo(Todo todo) {
        return todoRepository.save(todo).getId();
    }

    public void updateTodo(String todoId, Todo todo) {
        var optionalTodo = todoRepository.findById(todoId);

        if(optionalTodo.isPresent()) {
            todoRepository.save(todo);
        } else {
            throw new RuntimeException("Todo with ID " + todo + " does not exist!");
        }
    }

    public Optional<Todo> getTodo(String todoId) {
        return todoRepository.findById(todoId);
    }

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public void deleteTodo(String todoId) {
        todoRepository.deleteById(todoId);
    }
}
