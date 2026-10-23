package com.example.demo.model.requestDTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TaskUpdateRequestDTO {
    private String name;
    private String description;
    private LocalDate dateStart;
    private LocalDate dateFinish;
}
