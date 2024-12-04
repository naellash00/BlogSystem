package com.example.blogsystem.Service;

import com.example.blogsystem.ApiResponse.ApiException;
import com.example.blogsystem.Model.Comment;
import com.example.blogsystem.Repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    public CommentService(CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }
    public List<Comment> getAllComments(){
        return commentRepository.findAll();
    }

    public void addComment(Comment comment){
        commentRepository.save(comment);
    }

    public void updateComment(Integer id, Comment comment){
        Comment oldComment = commentRepository.findCommentById(id);
        if(oldComment==null)
            throw new ApiException("comment not found");

        oldComment.setContent(comment.getContent());
        oldComment.setCommentdate(comment.getCommentdate());
        oldComment.setPostid(comment.getPostid());
        oldComment.setUserid(comment.getUserid());
        commentRepository.save(oldComment);
    }

    public void deleteComment(Integer id){
        Comment comment = commentRepository.findCommentById(id);
        if(comment==null)
            throw new ApiException("comment not found");

        commentRepository.delete(comment);
    }

    public List<Comment> getAllPostComments(Integer postid){
        List<Comment> postComments = commentRepository.findPostComments(postid);
        if(postComments.isEmpty())
            throw new ApiException("comment not found");

        return postComments;
    }

}











