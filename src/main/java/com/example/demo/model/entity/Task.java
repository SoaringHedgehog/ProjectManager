package com.example.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "tasks")
@Getter @Setter
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; //Потом замена на UUID

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

    public Task(int id, String name, String description, LocalDate dateStart, LocalDate dateFinish, Project project){
        this.id = id;
        this.name = name;
        this.description = description;
        this.dateStart = dateStart;
        this.dateFinish = dateFinish;
        this.project = project;
    }

    public String toString(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return "Id: " + id + "\n\tНазвание: " + name + "\n\tОписание: " + description
                + "\n\tДата начала:\t" + dtf.format(dateStart) + "\n\tДата окончания:\t" + dtf.format(dateFinish)
                + "\n\tПроект\t" + project;
    }
}
