package uk.co.datadisk.webservices.restfulwebservices.services;

import org.springframework.stereotype.Service;
import uk.co.datadisk.webservices.restfulwebservices.entities.Todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoHardcodedService {

    private static List<Todo> todos = new ArrayList<>();
    private static int idCounter = 0;

    static {
        todos.add(new Todo(++idCounter, "Paul Valle", "Learn to program in Java", new Date(), false));
        todos.add(new Todo(++idCounter, "Paul Valle", "Learn to program in Angular 7", new Date(), false));
        todos.add(new Todo(++idCounter, "Paul Valle", "Learn to program in JavaScript", new Date(), false));
    }

    public List<Todo> findAll() {
        return todos;
    }
}
