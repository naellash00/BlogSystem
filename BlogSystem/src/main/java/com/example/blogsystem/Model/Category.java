package com.example.blogsystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "name cannot be empty")
    @Column(columnDefinition = "varchar(15) not null")
    private String name;

    public @NotEmpty(message = "name cannot be empty") String getName() {
        return name;
    }

    public void setName(@NotEmpty(message = "name cannot be empty") String name) {
        this.name = name;
    }
}
