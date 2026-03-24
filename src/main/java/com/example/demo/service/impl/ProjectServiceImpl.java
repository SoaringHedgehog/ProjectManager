package com.example.demo.service.impl;

import com.example.demo.model.entity.Project;
import com.example.demo.model.request.ProjectUpdateRequest;
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
    public Project updateFieldById(int projectId, ProjectUpdateRequest projectUpdateRequest){
        Project project = projectRepository.findById(projectId);
        project.setName(projectUpdateRequest.getName());
        project.setDescription(projectUpdateRequest.getDescription());
        project.setDateStart(projectUpdateRequest.getDateStart());
        project.setDateFinish(projectUpdateRequest.getDateFinish());
        return projectRepository.save(project);
    }

    @Override
    @Transactional
    public Project deleteById(int projectId){
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
