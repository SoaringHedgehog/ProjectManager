package com.example.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "tasks")
@Getter @Setter
@NoArgsConstructor
@ToString
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    private String name;

    @Column
    private String description;

    @Column(name = "dateStart")
    private LocalDate dateStart;

    @Column(name = "dateFinish")
    private LocalDate dateFinish;

    @ManyToOne
    @JsonBackReference
    private ProjectEntity projectEntity;

    public TaskEntity(UUID id, String name, String description, LocalDate dateStart, LocalDate dateFinish, ProjectEntity projectEntity){
        this.id = id;
        this.name = name;
        this.description = description;
        this.dateStart = dateStart;
        this.dateFinish = dateFinish;
        this.projectEntity = projectEntity;
    }
}
