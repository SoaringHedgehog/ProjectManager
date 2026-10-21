package com.example.demo.repository.base;

import com.example.demo.model.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskEntity, String> {
    TaskEntity findById(int id);
    TaskEntity findByName(String name);
    TaskEntity deleteById(int id);
    TaskEntity deleteByName(String name);
}
