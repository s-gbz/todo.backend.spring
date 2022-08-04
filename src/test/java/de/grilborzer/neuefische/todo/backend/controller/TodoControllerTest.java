package de.grilborzer.neuefische.todo.backend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.grilborzer.neuefische.todo.backend.persistence.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = TodoController.class)
class TodoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAllTodos() throws Exception {
        mockMvc.perform(get("/todos")
                        .contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    public void createEmployeeAPI() throws Exception
    {
        mockMvc.perform( MockMvcRequestBuilders
                        .post("/employees")
                        .content(asJsonString(new Todo("My first todo", false)))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.employeeId").exists());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}