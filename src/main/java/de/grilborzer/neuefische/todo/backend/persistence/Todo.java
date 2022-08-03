package de.grilborzer.neuefische.todo.backend.persistence;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;


@Getter
@Setter
public class Todo {

    @Id
    public String id;
    public String title;
    public boolean status;

    public Todo(String title, boolean status) {
        this.title = title;
        this.status = status;
    }
}
