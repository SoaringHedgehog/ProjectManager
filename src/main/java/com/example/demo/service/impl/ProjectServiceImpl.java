package com.example.demo.service.impl;

import com.example.demo.model.entity.ProjectEntity;
import com.example.demo.model.requestDTO.ProjectUpdateRequestDTO;
import com.example.demo.repository.base.ProjectRepository;
import com.example.demo.service.ProjectService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository){
        this.projectRepository = projectRepository;
    }

    @Override
    public ProjectEntity create(ProjectEntity projectEntity){
        return projectRepository.save(projectEntity);
    }

    @Override
    public ProjectEntity findById(int projectId){
        return projectRepository.findById(projectId);
    }

    @Override
    public ProjectEntity findByName(String projectName){
        return projectRepository.findByName(projectName);
    }

    @Override
    @Transactional
    public ProjectEntity updateFieldById(int projectId, ProjectUpdateRequestDTO projectUpdateRequestDTO){
        ProjectEntity projectEntity = projectRepository.findById(projectId);
        projectEntity.setName(projectUpdateRequestDTO.getName());
        projectEntity.setDescription(projectUpdateRequestDTO.getDescription());
        projectEntity.setDateStart(projectUpdateRequestDTO.getDateStart());
        projectEntity.setDateFinish(projectUpdateRequestDTO.getDateFinish());
        return projectRepository.save(projectEntity);
    }

    @Override
    @Transactional
    public ProjectEntity deleteById(int projectId){
        return projectRepository.deleteById(projectId);
    }

    @Override
    @Transactional
    public ProjectEntity deleteByName(String projectName){
        return projectRepository.deleteByName(projectName);
    }

    @Override
    public List<ProjectEntity> getAllProjects(){
        return projectRepository.findAll();
    }
}
