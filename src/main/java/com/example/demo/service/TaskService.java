package com.example.demo.service;

import com.example.demo.entity.Task;
import com.example.demo.entity.User;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface TaskService {
    Task create(Task task);
    Task findById(int taskId);
    Task findByName(String taskName);
    int updateFieldById(int taskId, String fieldForUpdate, String newValue);
    int updateFieldByName(String taskName, String fieldForUpdate, String newValue);
    Task deleteById(int taskId);
    Task deleteByName(String taskName);
    List<Task> getAllTasks();
}
