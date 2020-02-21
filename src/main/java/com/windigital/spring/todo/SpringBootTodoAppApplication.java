package com.windigital.spring.todo;

import com.windigital.spring.todo.domain.Todo;
import com.windigital.spring.todo.domain.User;
import com.windigital.spring.todo.enums.Role;
import com.windigital.spring.todo.repository.TodoRepository;
import com.windigital.spring.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.*;

@SpringBootApplication
public class SpringBootTodoAppApplication {
    private final TodoRepository todoRepository;
    private final UserService userService;

    @Autowired
    public SpringBootTodoAppApplication(TodoRepository todoRepository, UserService userService) {
        this.todoRepository = todoRepository;
        this.userService = userService;
    }

    public static void main(String[] args) {

        SpringApplication.run(SpringBootTodoAppApplication.class, args);
    }

    @PostConstruct
    public void init() {
        Collection<Todo> todos = Arrays.asList(new Todo("Learn Spring", "Yes"), new Todo("Learn Driving", "No"), new Todo("Go for a Walk", "No"), new Todo("Cook Dinner", "Yes"));
        todos.forEach(todoRepository::save);
        User user = new User();
        user.setUsername("user");
        user.setPassword("user");
        userService.save(user);

        User user1 = new User();
        user1.setUsername("admin");
        user1.setPassword("admin");
        userService.save(user1);
    }
}
