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
@ToString
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String login;

    @Column(name = "passwordHash", nullable = false)
    private String passwordHash;

    @Enumerated(EnumType.STRING)
    @Column(name = "roleTypeEnum", nullable = false)
    private RoleTypeEnum roleTypeEnum;

    @OneToMany(mappedBy = "userEntity",
            cascade = CascadeType.REMOVE,
            orphanRemoval = true)
    @JsonManagedReference
    private List<ProjectEntity> projectEntities;

    public UserEntity(UUID id, String login, String passwordHash, RoleTypeEnum roleTypeEnum){
        this.id = id;
        this.login = login;
        this.passwordHash = passwordHash;
        this.roleTypeEnum = roleTypeEnum;
        this.projectEntities = new ArrayList<>();
    }
}