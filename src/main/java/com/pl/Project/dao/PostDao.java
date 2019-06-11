package com.pl.Project.dao;

import com.pl.Project.entity.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostDao extends CrudRepository<Post, Long> {

    public Post findByTitle(String title);

}
