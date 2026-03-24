package com.example.demo.repository;

import com.example.demo.model.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface TaskRepository extends JpaRepository<Task, String> {
    Task findById(int id);
    Task findByName(String name);
    Task deleteById(int id);
    Task deleteByName(String name);
}
