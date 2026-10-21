package com.example.demo.service;

import com.example.demo.model.entity.TaskEntity;
import com.example.demo.model.requestDTO.TaskUpdateRequestDTO;

import java.util.List;

public interface TaskService {
    TaskEntity create(TaskEntity taskEntity);
    TaskEntity findById(int taskId);
    TaskEntity findByName(String taskName);
    TaskEntity updateFieldById(int taskId, TaskUpdateRequestDTO taskUpdateRequestDTO);
    TaskEntity deleteById(int taskId);
    TaskEntity deleteByName(String taskName);
    List<TaskEntity> getAllTasks();
}
