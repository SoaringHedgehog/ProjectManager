package com.example.demo.repository;

import com.example.demo.model.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ProjectRepository extends JpaRepository<Project, String> {
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE projects SET ?2 = ?3 WHERE id = ?1", nativeQuery = true)
    int updateFieldById(int id, String fieldName, String newValue);

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE projects SET ?2 = ?3 WHERE name = ?1", nativeQuery = true)
    int updateFieldByName(String name, String fieldName, String newValue);

    Project findById(int id);
    Project findByName(String name);
    int deleteById(int id);
    Project deleteByName(String name);
}
