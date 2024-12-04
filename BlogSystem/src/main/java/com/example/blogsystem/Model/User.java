package com.example.blogsystem.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.Check;

import java.time.LocalDate;


@Entity
@Check(constraints = "length(username)>= 5 and length(password) >= 5")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "username cannot be empty")
    @Size(min = 5, message = "username cannot be less than 5")
    @Column(columnDefinition = "varchar(15) not null unique")
    private String username;

    @NotEmpty(message = "password cannot be empty")
    @Size(min = 5, message = "password cannot be less than 5")
    @Column(columnDefinition = "varchar(15) not null")
    private String password;

    @NotEmpty(message = "email cannot be empty")
    @Email(message = "Enter a valid email")
    @Column(columnDefinition = "varchar(30) not null unique")
    private String email;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(columnDefinition = "date")
    private LocalDate registrationDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotEmpty(message = "username cannot be empty") @Size(min = 5, message = "username cannot be less than 5") String getUsername() {
        return username;
    }

    public void setUsername(@NotEmpty(message = "username cannot be empty") @Size(min = 5, message = "username cannot be less than 5") String username) {
        this.username = username;
    }

    public @NotEmpty(message = "password cannot be empty") @Size(min = 5, message = "password cannot be less than 5") String getPassword() {
        return password;
    }

    public void setPassword(@NotEmpty(message = "password cannot be empty") @Size(min = 5, message = "password cannot be less than 5") String password) {
        this.password = password;
    }

    public @NotEmpty(message = "email cannot be empty") @Email(message = "Enter a valid email") String getEmail() {
        return email;
    }

    public void setEmail(@NotEmpty(message = "email cannot be empty") @Email(message = "Enter a valid email") String email) {
        this.email = email;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }
}
