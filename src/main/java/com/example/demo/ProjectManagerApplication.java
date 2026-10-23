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
INSERT INTO Users (id, login, password_hash, role_type_enum)
VALUES ('3864bc41-7701-46ab-bb5b-2bf4b4edde9f', 'asd', 'd9729feb74992cc3482b350163a1a010', 'USER'),
       ('6f3d5588-75fe-4fcd-bf2f-548c799c769d', 'zxc', '146b65fd2004858b1c615bc8cf8b8a5b', 'ADMINISTRATOR');



INSERT INTO Projects (id, name, description, date_start, date_finish, user_entity_id)
VALUES ('832f72a1-f55f-4082-b02b-3f11540fe9c0', 'John', 'Купить пудинг', PARSEDATETIME('01.01.2020', 'dd.MM.yyyy'), PARSEDATETIME('01.02.2020', 'dd.MM.yyyy'), '3864bc41-7701-46ab-bb5b-2bf4b4edde9f'),
       ('9f83215c-56f5-461c-9ca0-f061454f73f3', 'Artemon', 'Устроить марафон', PARSEDATETIME('03.03.2000', 'dd.MM.yyyy'), PARSEDATETIME('03.05.2000', 'dd.MM.yyyy'), '3864bc41-7701-46ab-bb5b-2bf4b4edde9f'),
       ('2ea40038-3bd3-459f-9a57-b3120d0a0629', 'Pelmen', 'Съездить в путешествие', PARSEDATETIME('10.10.2010', 'dd.MM.yyyy'), PARSEDATETIME('30.10.2011', 'dd.MM.yyyy'), '6f3d5588-75fe-4fcd-bf2f-548c799c769d');


INSERT INTO Tasks (id, name, description, date_start, date_finish, project_entity_id)
VALUES (RANDOM_UUID(), 'Купить рыбу', 'За 300 рублей', PARSEDATETIME('01.01.2000', 'dd.MM.yyyy'), PARSEDATETIME('02.01.2000', 'dd.MM.yyyy'), '9f83215c-56f5-461c-9ca0-f061454f73f3'),
       (RANDOM_UUID(), 'Съесть торт', 'Шоколадный', PARSEDATETIME('10.10.2010', 'dd.MM.yyyy'), PARSEDATETIME('15.10.2010', 'dd.MM.yyyy'),'2ea40038-3bd3-459f-9a57-b3120d0a0629'),
       (RANDOM_UUID(), 'Написать другу', 'Ивану', PARSEDATETIME('20.10.2010', 'dd.MM.yyyy'), PARSEDATETIME('25.10.2010', 'dd.MM.yyyy'),'832f72a1-f55f-4082-b02b-3f11540fe9c0');


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