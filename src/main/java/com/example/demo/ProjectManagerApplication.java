package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProjectManagerApplication.class, args);
    }
}

/*
INSERT INTO Users (login, password_hash, role_type)
VALUES ('asd', 'd9729feb74992cc3482b350163a1a010', 'USER'),
       ('zxc', '146b65fd2004858b1c615bc8cf8b8a5b', 'ADMINISTRATOR');
 */