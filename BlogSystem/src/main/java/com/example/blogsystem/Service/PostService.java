package com.example.blogsystem.Service;

import com.example.blogsystem.ApiResponse.ApiException;
import com.example.blogsystem.Model.Post;
import com.example.blogsystem.Repository.PostRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;
    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }

    public void addPost(Post post){
        postRepository.save(post);
    }

    public void updatePost(Integer id, Post post){
        Post oldPost = postRepository.findPostById(id);
        if(oldPost==null)
            throw new ApiException("post not found");

        oldPost.setTitle(post.getTitle());
        oldPost.setContent(post.getContent());
        oldPost.setCategoryId(post.getCategoryId());
        oldPost.setPublishDate(post.getPublishDate());
        postRepository.save(oldPost);
    }

    public void deletePost(Integer id){
        Post post = postRepository.findPostById(id);
        if(post==null)
            throw new ApiException("post not found");

        postRepository.delete(post);
    }

    public List<Post> getSameUserPosts(Integer userid){
        List<Post> sameUserPosts = postRepository.getAllPostsBySameUser(userid);
        if(sameUserPosts.isEmpty()){
            throw new ApiException("user posts list not found");
        }
        return sameUserPosts;
    }

    public Post getPostByTitle(String title){
        Post post = postRepository.findPostByItsTitle(title);
        if(post==null)

            throw new ApiException("post not found");
        return post;
    }

    public List<Post> getPostsBeforeDate(LocalDate date){
        List<Post> postsBeforeDate = postRepository.getPostsBeforeDate(date);
        if(postsBeforeDate.isEmpty())
            throw new ApiException("posts not found");

        return postsBeforeDate;
    }
}


