package com.example.blogsystem.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

   // @NotNull(message = "category id cannot be empty")
    @Column(columnDefinition = "int not null")
    private Integer categoryId;

    @NotEmpty(message = "title cannot be empty")
    @Column(columnDefinition = "varchar(15) not null unique")
    private String title;

    @NotEmpty(message = "content cannot be empty")
    @Column(columnDefinition = "varchar(100) not null")
    private String content;

    //@NotNull(message = "user id cannot be empty")
    @Column(columnDefinition = "int not null")
    private Integer userid;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(columnDefinition = "date")
    private LocalDate publishDate;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public @NotEmpty(message = "title cannot be empty") String getTitle() {
        return title;
    }

    public void setTitle(@NotEmpty(message = "title cannot be empty") String title) {
        this.title = title;
    }

    public @NotEmpty(message = "content cannot be empty") String getContent() {
        return content;
    }

    public void setContent(@NotEmpty(message = "content cannot be empty") String content) {
        this.content = content;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }
}





