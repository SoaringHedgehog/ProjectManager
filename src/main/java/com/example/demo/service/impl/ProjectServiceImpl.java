package com.example.demo.service.impl;

import com.example.demo.entity.Project;
import com.example.demo.repository.ProjectRepository;
import com.example.demo.service.ProjectService;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository){
        this.projectRepository = projectRepository;
    }

    public Project create(Project project){
        return projectRepository.save(project);
    }

    public Project findById(int projectId){
        return projectRepository.findById(projectId);
    }

    public Project findByName(String projectName){
        return projectRepository.findByName(projectName);
    }
    public Project updateById(int projectId, String fieldForUpdate, String newValue){
        return projectRepository.updateById(projectId, fieldForUpdate, newValue);
    }
    public Project updateByName(String projectName, String fieldForUpdate, String newValue){
        return projectRepository.updateByName(projectName, fieldForUpdate, newValue);
    }
    public Project deleteById(int projectId){
        return projectRepository.deleteById(projectId);
    }
    public Project deleteByName(String projectName){
        return projectRepository.deleteByName(projectName);
    }
}
