package de.grilborzer.neuefische.todo.backend.controller;

import de.grilborzer.neuefische.todo.backend.exception.TodoNotFoundException;
import de.grilborzer.neuefische.todo.backend.persistence.Todo;
import de.grilborzer.neuefische.todo.backend.persistence.TodoRepository;
import de.grilborzer.neuefische.todo.backend.service.TodoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

//@ExtendWith
@WebMvcTest
public class TodoControllerIntegrationTest {

    @MockBean
    private TodoRepository todoRepository;

    @SpyBean
    private TodoService todoService;

    @InjectMocks
    private TodoController todoController;

    @BeforeEach
    public void setUp() {
        String firstTodoId = "First ID";

        Todo firstTodo = new Todo("My first todo", false);
        firstTodo.setId(firstTodoId);

        Mockito.when(todoRepository.findById(firstTodoId))
                .thenReturn(Optional.of(firstTodo));
    }

    @Test
    public void getTodoShouldReturnRequestedItem() {
        String firstTodoId = "First ID";

        Todo foundTodo = todoService.getTodo(firstTodoId);

        assertThat(foundTodo.getId()).isEqualTo(firstTodoId);
    }

    @Test
    public void getTodoShouldThrowTodoNotFoundExceptionIfIdDoesntMatch() {
        assertThrows(TodoNotFoundException.class, () -> todoService.getTodo("Invalid ID!"));
    }
}
