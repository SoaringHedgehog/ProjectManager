package com.example.demo.service;

import com.example.demo.model.entity.ProjectEntity;
import com.example.demo.model.requestDTO.ProjectUpdateRequestDTO;

import java.util.List;

public interface ProjectService {
    ProjectEntity create(ProjectEntity projectEntity);
    ProjectEntity findById(int projectId);
    ProjectEntity findByName(String projectName);
    ProjectEntity updateFieldById(int projectId, ProjectUpdateRequestDTO projectUpdateRequestDTO);
    ProjectEntity deleteById(int projectId);
    ProjectEntity deleteByName(String projectName);
    List<ProjectEntity> getAllProjects();
}
