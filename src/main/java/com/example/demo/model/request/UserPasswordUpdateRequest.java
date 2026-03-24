package com.example.demo.model.request;

import lombok.Data;

@Data
public class UserPasswordUpdateRequest {
    private String passwordHash;
}
