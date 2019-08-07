package com.pl.Project.dao;

import com.pl.Project.entity.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentDao extends CrudRepository<Comment, Long> {
    public List<Comment> findByUserId(Long userId);
    public List<Comment> findByPostId(Long postId);
}
