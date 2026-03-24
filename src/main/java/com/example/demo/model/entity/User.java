package com.example.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String login;

    @Column(name = "passwordHash", nullable = false)
    private String passwordHash;

    @Enumerated(EnumType.STRING)
    @Column(name = "roleType", nullable = false)
    private RoleType roleType;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<Project> projects;

    public User(UUID id, String login, String passwordHash, RoleType roleType){
        this.id = id;
        this.login = login;
        this.passwordHash = passwordHash;
        this.roleType = roleType;
        this.projects = new ArrayList<>();
    }

    @Override
    public String toString(){
        return "id: " + id + "\n\tЛогин: " + login + "\n\tХэш пароля: " + passwordHash
                + "\n\tРоль: " + roleType.displayName();
    }
}