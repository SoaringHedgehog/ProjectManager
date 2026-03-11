package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String login;

    @Column(nullable = false)
    private String passwordHash;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoleType roleType;

    @OneToMany(mappedBy = "user")
    private List<Project> projects;

    public User(int id, String login, String passwordHash, RoleType roleType){
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