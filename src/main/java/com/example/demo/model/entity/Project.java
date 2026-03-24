package com.example.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "projects")
@Getter @Setter
@NoArgsConstructor // TODO Для JPA?
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; //Потом замена типа на UUID

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
    private User user;

    @OneToMany(mappedBy = "project")
    @JsonManagedReference
    private List<Task> tasks;

    public Project(int id, String name, String description, LocalDate dateStart, LocalDate dateFinish, User user){
        this.id = id;
        this.name = name;
        this.description = description;
        this.dateStart = dateStart;
        this.dateFinish = dateFinish;
        this.user = user;
        this.tasks = new ArrayList<>();
    }

    public String toString(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return "Id: " + id + "\n\tНазвание: " + name + "\n\tОписание: " + description
                + "\n\tДата начала: " + dtf.format(dateStart) + "\n\tДата окончания: " + dtf.format(dateFinish)
                + "\n\tПользователь: " + user;
    }
}
