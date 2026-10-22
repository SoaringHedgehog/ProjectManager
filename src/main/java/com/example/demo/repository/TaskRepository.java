package com.example.demo.repository;

import com.example.demo.model.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskRepository extends JpaRepository<TaskEntity, UUID> {
    TaskEntity findByName(String name);
    int deleteByName(String name);
}
