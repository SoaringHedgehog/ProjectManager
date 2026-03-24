package com.example.demo.model.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ProjectUpdateRequest {
    private String name;
    private String description;
    private LocalDate dateStart;
    private LocalDate dateFinish;
}