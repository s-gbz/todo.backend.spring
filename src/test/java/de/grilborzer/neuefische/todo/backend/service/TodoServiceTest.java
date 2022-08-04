package de.grilborzer.neuefische.todo.backend.service;

import de.grilborzer.neuefische.todo.backend.persistence.Todo;
import de.grilborzer.neuefische.todo.backend.persistence.TodoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

//@DataMongoTest
@ExtendWith(MockitoExtension.class)
class TodoServiceTest {

    @Mock
    TodoRepository todoRepository;

    TodoService todoService;

    @BeforeEach
    void setUp() {
        todoService = new TodoService(todoRepository);
    }

    @Test
    void creatingATodoReturnsAnId() {
        Todo firstTodo = new Todo("My first todo", false);

        when(todoRepository.save(any(Todo.class))).then(returnMockId())



        assertThat(todoService.saveTodo(firstTodo)).isNotNull();
    }

    private String returnMockId() {
        return "abMeinsc1";
    }

    @Test
    void getAllTodos() {
    }
}