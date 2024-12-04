package com.example.blogsystem.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "user id cannot be empty")
    @Column(columnDefinition = "int not null")
    private Integer userid;

    @NotNull(message = "post id cannot be empty")
    @Column(columnDefinition = "int not null")
    private Integer postid;

    @NotEmpty(message = "content cannot be empty")
    @Column(columnDefinition = "varchar(100) not null")
    private String content;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(columnDefinition = "date")
    private LocalDate commentdate;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotNull(message = "user id cannot be empty") Integer getUserid() {
        return userid;
    }

    public void setUserid(@NotNull(message = "user id cannot be empty") Integer userid) {
        this.userid = userid;
    }

    public @NotNull(message = "post id cannot be empty") Integer getPostid() {
        return postid;
    }

    public void setPostid(@NotNull(message = "post id cannot be empty") Integer postid) {
        this.postid = postid;
    }

    public @NotEmpty(message = "content cannot be empty") String getContent() {
        return content;
    }

    public void setContent(@NotEmpty(message = "content cannot be empty") String content) {
        this.content = content;
    }

    public LocalDate getCommentdate() {
        return commentdate;
    }

    public void setCommentdate(LocalDate commentdate) {
        this.commentdate = commentdate;
    }
}
