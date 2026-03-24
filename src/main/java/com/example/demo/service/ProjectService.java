package com.example.demo.service;

import com.example.demo.model.entity.Project;
import com.example.demo.model.request.ProjectUpdateRequest;

import java.util.List;

public interface ProjectService {
    Project create(Project project);
    Project findById(int projectId);
    Project findByName(String projectName);
    Project updateFieldById(int projectId, ProjectUpdateRequest projectUpdateRequest);
    Project deleteById(int projectId);
    Project deleteByName(String projectName);
    List<Project> getAllProjects();
}
