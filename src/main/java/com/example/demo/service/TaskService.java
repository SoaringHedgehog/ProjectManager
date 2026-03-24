package com.example.demo.service;

import com.example.demo.model.entity.Task;

import java.util.List;

public interface TaskService {
    Task create(Task task);
    Task findById(int taskId);
    Task findByName(String taskName);
    int updateFieldById(int taskId, String fieldForUpdate, String newValue);
    Task deleteById(int taskId);
    Task deleteByName(String taskName);
    List<Task> getAllTasks();
}
