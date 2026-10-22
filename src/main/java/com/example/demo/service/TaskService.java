package com.example.demo.service;

import com.example.demo.model.entity.ProjectEntity;
import com.example.demo.model.entity.TaskEntity;
import com.example.demo.model.requestDTO.TaskUpdateRequestDTO;
import com.example.demo.repository.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {
    @Autowired
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public TaskEntity create(TaskEntity taskEntity) {
        return taskRepository.save(taskEntity);
    }

    public TaskEntity findById(UUID taskId) {
        return taskRepository.findById(taskId).orElse(null);
    }

    public TaskEntity findByName(String taskName) {
        return taskRepository.findByName(taskName);
    }

    @Transactional
    public TaskEntity updateFieldById(UUID taskId, TaskUpdateRequestDTO taskUpdateRequestDTO) {
        TaskEntity taskEntity = taskRepository.findById(taskId).orElse(null);
        taskEntity.setName(taskUpdateRequestDTO.getName());
        taskEntity.setDescription(taskUpdateRequestDTO.getDescription());
        taskEntity.setDateStart(taskUpdateRequestDTO.getDateStart());
        taskEntity.setDateFinish(taskUpdateRequestDTO.getDateFinish());
        return taskRepository.save(taskEntity);
    }

    @Transactional
    public TaskEntity deleteById(UUID taskId) {
        TaskEntity taskEntity = taskRepository.findById(taskId).orElse(null);
        taskRepository.deleteById(taskId);
        return taskEntity;
    }

    @Transactional
    public int deleteByName(String taskName) {
        return taskRepository.deleteByName(taskName);
    }

    public List<TaskEntity> getAllTasks(){
        return taskRepository.findAll();
    }
}
