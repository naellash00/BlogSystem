package com.example.blogsystem.Controller;

import com.example.blogsystem.Model.Post;
import com.example.blogsystem.Service.PostService;
import jakarta.validation.Valid;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/get")
    public ResponseEntity getAllPosts() {
        List<Post> posts = postService.getAllPosts();
        return ResponseEntity.status(200).body(posts);
    }

    @PostMapping("/add")
    public ResponseEntity addPost(@RequestBody @Valid Post post, Errors errors) {
        if (errors.hasErrors())
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());

        postService.addPost(post);
        return ResponseEntity.status(200).body("post added successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updatePost(@PathVariable Integer id, @RequestBody @Valid Post post, Errors errors) {
        if (errors.hasErrors())
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());

        postService.updatePost(id, post);
        return ResponseEntity.status(200).body("post updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletePost(@PathVariable Integer id) {
        postService.deletePost(id);
        return ResponseEntity.status(200).body("post deleted successfully");
    }

    @GetMapping("/get/same/user/posts/{id}")
    public ResponseEntity getSameUserPosts(@PathVariable Integer id){
        List<Post> sameUsersPosts = postService.getSameUserPosts(id);
        return ResponseEntity.status(200).body(sameUsersPosts);
    }

    @GetMapping("/get/post/by/title/{title}")
    public ResponseEntity getPostByTitle(@PathVariable String title){
        Post post = postService.getPostByTitle(title);
        return ResponseEntity.status(200).body(post);
    }

    @GetMapping("/get/posts/by/date/{date}")
    public ResponseEntity getPostsBeforeDate(@PathVariable LocalDate date){
        List<Post> postsBeforeDate = postService.getPostsBeforeDate(date);
        return ResponseEntity.status(200).body(postsBeforeDate);
    }

}












