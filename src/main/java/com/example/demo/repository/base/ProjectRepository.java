package com.example.demo.repository.base;

import com.example.demo.model.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<ProjectEntity, String> {
    ProjectEntity findById(int id);
    ProjectEntity findByName(String name);
    ProjectEntity deleteById(int id);
    ProjectEntity deleteByName(String name);
}