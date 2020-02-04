package com.windigital.spring.todo.repository;

import com.windigital.spring.todo.domain.Todo;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends PagingAndSortingRepository<Todo, Long> {

}
