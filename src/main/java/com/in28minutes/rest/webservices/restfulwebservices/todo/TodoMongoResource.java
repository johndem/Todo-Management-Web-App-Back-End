package com.in28minutes.rest.webservices.restfulwebservices.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class TodoMongoResource {

	@Autowired
	private TodoMongoRepository todoMongoRepository;

	@GetMapping("/mongo/users/{username}/todos")
	public List<TodoEntity> getAllTodos(@PathVariable String username) {
		return todoMongoRepository.findByUsername(username);
	}

	@GetMapping("/mongo//users/{username}/todos/{id}")
	public TodoEntity getTodo(@PathVariable String username, @PathVariable String id) {
		return todoMongoRepository.findById(id).get();
	}

	@DeleteMapping("/mongo/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable String id) {
		todoMongoRepository.deleteById(id);

		return ResponseEntity.noContent().build();
	}

	@PutMapping("/mongo/users/{username}/todos/{id}")
	public ResponseEntity<TodoEntity> updateTodo(@PathVariable String username,
										   @PathVariable String id, @RequestBody TodoEntity todo) {
		todo.setUsername(username);
		TodoEntity todoUpdated = todoMongoRepository.save(todo);
		return new ResponseEntity<TodoEntity>(todoUpdated, HttpStatus.OK);
	}

	@PostMapping("/mongo/users/{username}/todos")
	public ResponseEntity<Void> createTodo(@PathVariable String username, @RequestBody TodoEntity todo) {
		todo.setId(null);
		todo.setUsername(username);

		TodoEntity createdTodo = todoMongoRepository.save(todo);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
			.buildAndExpand(createdTodo.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}
}
