package uk.co.datadisk.webservices.restfulwebservices.controllers;

import org.springframework.web.bind.annotation.*;
import uk.co.datadisk.webservices.restfulwebservices.beans.HelloWorldBean;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class HelloWorldController {

    @GetMapping(path="/hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping(path="/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        // throw new RuntimeException("Some error has happened, please contact support");
        return new HelloWorldBean("Hello World from Paul Valle");
    }

    @GetMapping(path="/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldBeanPathVariable(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello %s", name));
    }
}
