package com.example.demo.service;

import com.example.demo.model.entity.Task;
import com.example.demo.model.request.TaskUpdateRequest;

import java.util.List;

public interface TaskService {
    Task create(Task task);
    Task findById(int taskId);
    Task findByName(String taskName);
    Task updateFieldById(int taskId, TaskUpdateRequest taskUpdateRequest);
    Task deleteById(int taskId);
    Task deleteByName(String taskName);
    List<Task> getAllTasks();
}
