package com.example.demo.repository;

import com.example.demo.model.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProjectRepository extends JpaRepository<ProjectEntity, UUID> {
    ProjectEntity findByName(String name);
    int deleteByName(String name);
}