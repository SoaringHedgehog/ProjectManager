package com.example.demo.service;

import com.example.demo.entity.Project;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public interface ProjectService {
    public Project create(Project project);
    public Project findById(int projectId);
    public Project findByName(String projectName);
    public Project updateById(int projectId, String fieldForUpdate, String newValue);
    public Project updateByName(String projectName, String fieldForUpdate, String newValue);
    public Project deleteById(int projectId);
    public Project deleteByName(String projectName);
}
