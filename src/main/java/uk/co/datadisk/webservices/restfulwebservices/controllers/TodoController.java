package uk.co.datadisk.webservices.restfulwebservices.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import uk.co.datadisk.webservices.restfulwebservices.entities.Todo;
import uk.co.datadisk.webservices.restfulwebservices.services.TodoHardcodedService;

import java.util.List;

@RestController
public class TodoController {

    @Autowired
    private TodoHardcodedService todoService;

    @GetMapping("/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username) {
        return todoService.findAll();
    }
}
