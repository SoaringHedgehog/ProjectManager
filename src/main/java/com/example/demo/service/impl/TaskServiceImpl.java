package com.example.demo.service.impl;

import com.example.demo.model.entity.Task;
import com.example.demo.repository.TaskRepository;
import com.example.demo.service.TaskService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @Override
    public Task create(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task findById(int taskId) {
        return taskRepository.findById(taskId);
    }

    @Override
    public Task findByName(String taskName) {
        return taskRepository.findByName(taskName);
    }

    @Override
    @Transactional
    public int updateFieldById(int taskId, String fieldForUpdate, String newValue) {
        return taskRepository.updateFieldById(taskId, fieldForUpdate, newValue);
    }

    @Override
    @Transactional
    public Task deleteById(int taskId) {
        return taskRepository.deleteById(taskId);
    }

    @Override
    @Transactional
    public Task deleteByName(String taskName) {
        return taskRepository.deleteByName(taskName);
    }

    @Override
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }
}
