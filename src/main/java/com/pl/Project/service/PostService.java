package com.pl.Project.service;

import com.pl.Project.dao.PostDao;
import com.pl.Project.entity.BookGenre;
import com.pl.Project.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostDao postDao;

    public List<Post> getPostList(){
        List<Post> posts = new ArrayList<>();
        this.postDao.findAll().forEach(posts::add);
        return posts;
    }

    public Post getPost(Long id){
        return this.postDao.findById(id).get();
    }

    public void addPost(Post post){
        this.postDao.save(post);
    }

    public void updatePost(Long id, String title, String author, double price, BookGenre genre){
        Post post = this.postDao.findById(id).get();
        post.setTitle(title);
        post.setAuthor(author);
        post.setPrice(price);
        post.setGenre(genre);
        this.postDao.save(post);
    }

    public void deletePost(Long id){
        this.postDao.deleteById(id);
    }

}
