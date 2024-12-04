package com.example.blogsystem.Controller;

import com.example.blogsystem.Model.Comment;
import com.example.blogsystem.Service.CommentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comment")
public class CommentController {
    private final CommentService commentService;
    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    @GetMapping("/get")
    public ResponseEntity getAllComments(){
        List<Comment> comments = commentService.getAllComments();
        return ResponseEntity.status(200).body(comments);
    }

    @PostMapping("/add")
    public ResponseEntity addComment(@RequestBody @Valid Comment comment, Errors errors){
        if(errors.hasErrors())
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());

        commentService.addComment(comment);
        return ResponseEntity.status(200).body("comment added successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateComment(@PathVariable Integer id, @RequestBody @Valid Comment comment, Errors errors){
        if(errors.hasErrors())
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());

        commentService.updateComment(id, comment);
        return ResponseEntity.status(200).body("comment updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteComment(@PathVariable Integer id){
        commentService.deleteComment(id);
        return ResponseEntity.status(200).body("comment deleted successfully");
    }

    @GetMapping("/get/post/comments/{postid}")
    public ResponseEntity getAllPostComments(@PathVariable Integer postid){
        List<Comment> postComments = commentService.getAllPostComments(postid);
        return ResponseEntity.status(200).body(postComments);
    }
}





