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



INSERT INTO Projects (name, description, date_start, date_finish, user_id)
VALUES ('John', 'Купить пудинг', PARSEDATETIME('01.01.2020', 'dd.MM.yyyy'), PARSEDATETIME('01.02.2020', 'dd.MM.yyyy'), 2),
       ('Artemon', 'Устроить марафон', PARSEDATETIME('03.03.2000', 'dd.MM.yyyy'), PARSEDATETIME('03.05.2000', 'dd.MM.yyyy'), 1),
       ('Pelmen', 'Съездить в путешествие', PARSEDATETIME('10.10.2010', 'dd.MM.yyyy'), PARSEDATETIME('30.10.2011', 'dd.MM.yyyy'), 1);



INSERT INTO Tasks (name, description, date_start, date_finish, project_id)
VALUES ('Купить рыбу', 'За 300 рублей', PARSEDATETIME('01.01.2000', 'dd.MM.yyyy'), PARSEDATETIME('02.01.2000', 'dd.MM.yyyy'), 2),
       ('Съесть торт', 'Шоколадный', PARSEDATETIME('10.10.2010', 'dd.MM.yyyy'), PARSEDATETIME('15.10.2010', 'dd.MM.yyyy'), 3),
       ('Написать другу', 'Ивану', PARSEDATETIME('20.10.2010', 'dd.MM.yyyy'), PARSEDATETIME('25.10.2010', 'dd.MM.yyyy'), 1);


{
    "login": "new user",
    "passwordHash": "ab6b65fd2004858b1c615bc8cf8b8fgh",
    "roleType": "ADMINISTRATOR"
}

{
    "name": "new project",
    "description": "Купить слона",
    "dateStart": "2020-03-03",
    "dateFinish": "2020-05-03",
    "user": {
        "id": 3
    }
}



 */