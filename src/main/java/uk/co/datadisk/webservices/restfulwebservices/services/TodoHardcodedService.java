package uk.co.datadisk.webservices.restfulwebservices.services;

import org.springframework.stereotype.Service;
import uk.co.datadisk.webservices.restfulwebservices.entities.Todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoHardcodedService {

    private static List<Todo> todos = new ArrayList<>();
    private static long idCounter = 0;

    static {
        todos.add(new Todo(++idCounter, "Paul Valle", "Learn to program in Java 11", new Date(119, 3, 1), false));
        todos.add(new Todo(++idCounter, "Paul Valle", "Learn to program in Angular 7", new Date(119, 6, 1), false));
        todos.add(new Todo(++idCounter, "Paul Valle", "Learn to program in JavaScript", new Date(119, 11, 1), false));
    }

    // CRUD Operations
    public List<Todo> findAll() {
        return todos;
    }

    public Todo findById(long id) {
        for(Todo todo: todos) {
            if(todo.getId() == id){
                return todo;
            }
        }
        return null;
    }

    public Todo deleteById(long id) {
        Todo todo = findById(id);
        if(todo == null) {
            return null;
        }

        if(todos.remove(todo)) {
            return todo;
        }

        return null;
    }

    public Todo save(Todo todo) {
        //CREATE
       if (todo.getId() == -1 || todo.getId() == 0){
           todo.setId(++idCounter);
           todos.add(todo);
       } else {
           // UPDATE
            deleteById(todo.getId());
            todos.add(todo);
       }

       return todo;
    }
}
