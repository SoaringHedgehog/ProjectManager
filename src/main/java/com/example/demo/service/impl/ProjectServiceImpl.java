package com.example.demo.service.impl;

import com.example.demo.model.entity.Project;
import com.example.demo.repository.ProjectRepository;
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
    public Project create(Project project){
        return projectRepository.save(project);
    }

    @Override
    public Project findById(int projectId){
        return projectRepository.findById(projectId);
    }

    @Override
    public Project findByName(String projectName){
        return projectRepository.findByName(projectName);
    }

    @Override
    @Transactional
    public int updateFieldById(int projectId, String fieldForUpdate, String newValue){
        return projectRepository.updateFieldById(projectId, fieldForUpdate, newValue);
    }

    @Override
    @Transactional
    public int updateFieldByName(String projectName, String fieldForUpdate, String newValue){
        return projectRepository.updateFieldByName(projectName, fieldForUpdate, newValue);
    }

    @Override
    @Transactional
    public int deleteById(int projectId){
        return projectRepository.deleteById(projectId);
    }

    @Override
    @Transactional
    public Project deleteByName(String projectName){
        return projectRepository.deleteByName(projectName);
    }

    @Override
    public List<Project> getAllProjects(){
        return projectRepository.findAll();
    }
}
