package de.grilborzer.neuefische.todo.backend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.grilborzer.neuefische.todo.backend.persistence.Todo;
import de.grilborzer.neuefische.todo.backend.persistence.TodoRepository;
import de.grilborzer.neuefische.todo.backend.service.TodoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = TodoController.class)
class TodoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    TodoService todoService;

    @MockBean
    TodoRepository todoRepository;

    @Test
    void getAllTodosShouldReturn200() throws Exception {
        mockMvc.perform(get("/v1/todos")
                        .contentType("application/json"))
                .andExpect(status().isOk()).andReturn();
    }

    @Test
    void saveTodoShouldReturn200() throws Exception {
        Todo firstTodo = new Todo("My first todo", false);

        mockMvc.perform(post("/v1/todos")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(firstTodo))
                )
                .andExpect(status().isOk()).andReturn();
    }
}