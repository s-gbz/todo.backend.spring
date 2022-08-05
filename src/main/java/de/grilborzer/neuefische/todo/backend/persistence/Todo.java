package de.grilborzer.neuefische.todo.backend.persistence;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Todo {

    @Id
    private String id;
    private String title;
    private boolean status;

    // Doesn't require ID explicitly as it's null anyway and will be handled by MongoDB
    public Todo(String title, boolean status) {
        this.title = title;
        this.status = status;
    }
}
