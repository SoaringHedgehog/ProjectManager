package com.example.demo.service;

import com.example.demo.model.entity.Project;

import java.util.List;

public interface ProjectService {
    Project create(Project project);
    Project findById(int projectId);
    Project findByName(String projectName);
    int updateFieldById(int projectId, String fieldForUpdate, String newValue);
    int updateFieldByName(String projectName, String fieldForUpdate, String newValue);
    int deleteById(int projectId);
    Project deleteByName(String projectName);
    List<Project> getAllProjects();
}
