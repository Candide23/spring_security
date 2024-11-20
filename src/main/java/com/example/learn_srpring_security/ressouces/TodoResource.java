package com.example.learn_srpring_security.ressouces;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class TodoResource {

    private Logger logger = LoggerFactory.getLogger(getClass());
    private static final List<Todo> TODOS_LIST =
            List.of(new Todo("in28minutes", "Learn AWS"),
                    new Todo("in28minutes", "Get AWS Certified"));



    @GetMapping("/todos")
    public List<Todo> retrieveAllTodos() {
        return TODOS_LIST;
    }

    @GetMapping("/users/{username}/todos")
    public Todo retrieveTodosForSpecificUser(@PathVariable("username") String username) {
        return TODOS_LIST.get(0);
    }

    @PostMapping("/users/{username}/todos")
    public void createTodoForSpecificUser(@PathVariable String username
            , @RequestBody Todo todo) {
        logger.info("Create {} for {}", todo, username);
    }

    record Todo (String username, String description) {

    }



}

