package de.grilborzer.neuefische.todo.backend.service;

import de.grilborzer.neuefische.todo.backend.persistence.Todo;
import de.grilborzer.neuefische.todo.backend.persistence.TodoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(MockitoExtension.class)
public class TodoServiceTest {

    TodoService todoService;
    @Mock
    TodoRepository todoRepository;

    @BeforeEach
    public void setUp() {
        todoService = new TodoService(todoRepository);
    }

    @Test
    public void creatingATodoReturnsAnId() {
        // Given
        String expectedId = "aNewId";
        Todo firstTodo = new Todo("My first todo", false);
        firstTodo.setId(expectedId);

        when(todoRepository.save(firstTodo)).thenReturn(firstTodo);

        // When
        String savedId = todoService.saveTodo(firstTodo);

        // Then
        assertThat(savedId).isEqualTo(expectedId);
    }

    @Test
    public void updatingAnExistingTodoModifiesItsState() {
        // Given
        String expectedId = "aNewId";
        Todo firstTodo = new Todo("My first todo", false);
        firstTodo.setId(expectedId);

        when(todoRepository.save(firstTodo)).thenReturn(firstTodo);

        // When
        String savedId = todoService.saveTodo(firstTodo);

        // Then
        assertThat(savedId).isEqualTo(expectedId);
    }

    @Test
    void getAllTodos() {
    }
}