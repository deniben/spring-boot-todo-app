package com.windigital.spring.todo.service;

import com.windigital.spring.todo.domain.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
