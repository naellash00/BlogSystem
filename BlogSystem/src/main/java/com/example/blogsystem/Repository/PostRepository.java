package com.example.blogsystem.Repository;

import com.example.blogsystem.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    Post findPostById(Integer id);

    @Query("select p from Post p where p.userid=?1")
    List<Post> getAllPostsBySameUser(Integer userid);

    @Query("select p from Post p where p.title = ?1")
    Post findPostByItsTitle(String title);

    @Query("select p from Post p where p.publishDate < ?1")
    List<Post> getPostsBeforeDate(LocalDate date);
}
