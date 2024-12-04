package com.example.blogsystem.Repository;

import com.example.blogsystem.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    Comment findCommentById(Integer id);

    @Query("select c from Comment c where c.postid = ?1")
    List<Comment> findPostComments(Integer postid);
}
