package com.example.demo.repository;

import com.example.demo.model.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ProjectRepository extends JpaRepository<Project, String> {
    Project findById(int id);
    Project findByName(String name);
    Project deleteById(int id);
    Project deleteByName(String name);
}