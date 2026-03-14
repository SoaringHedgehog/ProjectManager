package com.example.demo.repository;

import com.example.demo.entity.Project;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, String> {
    // JPQL
    @Modifying
    @Query("UPDATE User u SET u.passwordHash = :newPasswordHash WHERE u.id = :id")
    Project updateById(int projectId, String fieldForUpdate, String newValue);

    // SQL
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE users SET password_hash = :newPasswordHash WHERE login = :login", nativeQuery = true)
    Project updateByName(String projectName,String fieldForUpdate,String newValue);

    Project findById(int id);
    Project findByName(String name);
    Project deleteById(int id);
    Project deleteByName(String name);
}
