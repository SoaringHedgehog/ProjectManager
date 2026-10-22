package com.example.demo.service;

import com.example.demo.model.entity.ProjectEntity;
import com.example.demo.model.requestDTO.ProjectUpdateRequestDTO;
import com.example.demo.repository.ProjectRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProjectService {
    @Autowired
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository){
        this.projectRepository = projectRepository;
    }

    public ProjectEntity create(ProjectEntity projectEntity){
        return projectRepository.save(projectEntity);
    }

    public ProjectEntity findById(UUID projectId){
        return projectRepository.findById(projectId).orElse(null);
    }

    public ProjectEntity findByName(String projectName){
        return projectRepository.findByName(projectName);
    }

    @Transactional
    public ProjectEntity updateFieldById(UUID projectId, ProjectUpdateRequestDTO projectUpdateRequestDTO){
        ProjectEntity projectEntity = projectRepository.findById(projectId).orElse(null);
        projectEntity.setName(projectUpdateRequestDTO.getName());
        projectEntity.setDescription(projectUpdateRequestDTO.getDescription());
        projectEntity.setDateStart(projectUpdateRequestDTO.getDateStart());
        projectEntity.setDateFinish(projectUpdateRequestDTO.getDateFinish());
        return projectRepository.save(projectEntity);
    }

    @Transactional
    public ProjectEntity deleteById(UUID projectId){
        ProjectEntity projectEntity = projectRepository.findById(projectId).orElse(null);
        projectRepository.deleteById(projectId);
        return projectEntity;
    }

    @Transactional
    public int deleteByName(String projectName){
        return projectRepository.deleteByName(projectName);
    }

    public List<ProjectEntity> getAllProjects(){
        return projectRepository.findAll();
    }
}
