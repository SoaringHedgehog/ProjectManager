package com.example.demo.model.entity;

public enum RoleTypeEnum {
    USER("Обычный пользователь"),
    ADMINISTRATOR("Администратор");

    private String displayName;

    RoleTypeEnum(String displayName) {
        this.displayName = displayName;
    }

    public String displayName(){
        return displayName;
    }
}