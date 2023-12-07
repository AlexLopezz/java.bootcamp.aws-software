package com.alexdev.springboot_CRUD.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "db_profession")
@Getter @Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Profession {
    @Id
    private String id;

    private String name;

    private String description;
}