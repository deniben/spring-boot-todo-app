package com.windigital.spring.todo;

import com.windigital.spring.todo.domain.Todo;
import com.windigital.spring.todo.repository.TodoRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Collection;

@SpringBootApplication
public class SpringBootTodoAppApplication {
    public final TodoRepository todoRepository;

    public SpringBootTodoAppApplication(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public static void main(String[] args) {

        SpringApplication.run(SpringBootTodoAppApplication.class, args);
    }

    @PostConstruct
    public void init() {
        Collection<Todo> todos = Arrays.asList(new Todo("Learn Spring", "Yes"), new Todo("Learn Driving", "No"), new Todo("Go for a Walk", "No"), new Todo("Cook Dinner", "Yes"));
        todos.forEach(todoRepository::save);
    }
}
