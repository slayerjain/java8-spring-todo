package org.example.todo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private boolean completed;
}