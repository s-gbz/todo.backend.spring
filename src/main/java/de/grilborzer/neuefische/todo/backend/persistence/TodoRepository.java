package de.grilborzer.neuefische.todo.backend.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TodoRepository extends MongoRepository<Todo, String> { }
