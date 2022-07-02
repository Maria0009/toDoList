package com.overone.repository;

import com.overone.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findByUserNameOrderByTargetDateAsc(String user);
}
