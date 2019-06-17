package com.pl.Project.service;

import com.pl.Project.dao.PostDao;
import com.pl.Project.entity.BookGenre;
import com.pl.Project.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

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

    public void updatePost(Post post, Model m){
        if(post!=null){
            this.postDao.save(post);
            m.addAttribute("post",post);
        }

    }

    public void deletePost(Long id){
        this.postDao.deleteById(id);
    }

}
