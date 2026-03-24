package com.example.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Entity
@Table(name = "tasks")
@Getter @Setter
@NoArgsConstructor
@ToString
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id; //Потом замена на UUID

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
    private Project project;

    public Task(UUID id, String name, String description, LocalDate dateStart, LocalDate dateFinish, Project project){
        this.id = id;
        this.name = name;
        this.description = description;
        this.dateStart = dateStart;
        this.dateFinish = dateFinish;
        this.project = project;
    }
}
