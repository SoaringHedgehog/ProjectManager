package com.example.demo.service.impl;

import com.example.demo.model.entity.TaskEntity;
import com.example.demo.model.requestDTO.TaskUpdateRequestDTO;
import com.example.demo.repository.base.TaskRepository;
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
    public TaskEntity create(TaskEntity taskEntity) {
        return taskRepository.save(taskEntity);
    }

    @Override
    public TaskEntity findById(int taskId) {
        return taskRepository.findById(taskId);
    }

    @Override
    public TaskEntity findByName(String taskName) {
        return taskRepository.findByName(taskName);
    }

    @Override
    @Transactional
    public TaskEntity updateFieldById(int taskId, TaskUpdateRequestDTO taskUpdateRequestDTO) {
        TaskEntity taskEntity = taskRepository.findById(taskId);
        taskEntity.setName(taskUpdateRequestDTO.getName());
        taskEntity.setDescription(taskUpdateRequestDTO.getDescription());
        taskEntity.setDateStart(taskUpdateRequestDTO.getDateStart());
        taskEntity.setDateFinish(taskUpdateRequestDTO.getDateFinish());
        return taskRepository.save(taskEntity);
    }

    @Override
    @Transactional
    public TaskEntity deleteById(int taskId) {
        return taskRepository.deleteById(taskId);
    }

    @Override
    @Transactional
    public TaskEntity deleteByName(String taskName) {
        return taskRepository.deleteByName(taskName);
    }

    @Override
    public List<TaskEntity> getAllTasks(){
        return taskRepository.findAll();
    }
}
