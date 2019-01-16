package uk.co.datadisk.webservices.restfulwebservices.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import uk.co.datadisk.webservices.restfulwebservices.entities.Todo;
import uk.co.datadisk.webservices.restfulwebservices.repositories.TodoRepository;
import uk.co.datadisk.webservices.restfulwebservices.services.TodoHardcodedService;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TodoJpaController {

    @Autowired
    private TodoRepository todoJpaRepository;

    // CRUD Operations
    // CREATE operation
//    @PostMapping("/jpa/users/{username}/todos")
//    public ResponseEntity<Void> updateTodo( @PathVariable String username,
//                                            @RequestBody Todo todo ) {
//        Todo createdTodo = todoService.save(todo);
//
//        URI uri = ServletUriComponentsBuilder
//                .fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(createdTodo.getId())
//                .toUri();
//
//        return ResponseEntity.created(uri).build();
//    }

    // READ operations
    @GetMapping("/jpa/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username) {
        return todoJpaRepository.findByUsername(username);
    }

    @GetMapping("/jpa/users/{username}/todos/{id}")
    public Todo getTodo(@PathVariable String username, @PathVariable long id) {
        return todoJpaRepository.findById(id).get();
    }

    // UPDATE operation
//    @PutMapping("/jpa/users/{username}/todos/{id}")
//    public ResponseEntity<Todo> updateTodo( @PathVariable String username, @PathVariable long id,
//                                            @RequestBody Todo todo ) {
//        Todo todoUpdated = todoService.save(todo);
//        return new ResponseEntity<>(todoUpdated, HttpStatus.OK);
//    }

    // DELETE operation
//    @DeleteMapping("/jpa/users/{username}/todos/{id}")
//    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id){
//
//        Todo todo = todoService.deleteById(id);
//        if(todo != null) {
//            return ResponseEntity.noContent().build();
//        }
//        return ResponseEntity.notFound().build();
//    }
}
