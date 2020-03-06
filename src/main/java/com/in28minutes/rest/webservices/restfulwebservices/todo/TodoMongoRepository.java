package com.in28minutes.rest.webservices.restfulwebservices.todo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoMongoRepository extends MongoRepository<TodoEntity, String> {
    List<TodoEntity> findByUsername(String username);
}
