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

    public void updatePost(Long id, String title, String author, double price, String img, BookGenre genre, Model m){
        Post post = this.postDao.findById(id).get();
        if(title!=null)         post.setTitle(title); else post.setTitle(this.postDao.findById(id).get().getTitle());
        if(author!=null)        post.setAuthor(author); else post.setAuthor(this.postDao.findById(id).get().getAuthor());
        if(price!=0l)        post.setPrice(price); else post.setPrice(this.postDao.findById(id).get().getPrice());
        if(img!=null)        post.setImg(img); else post.setImg(this.postDao.findById(id).get().getImg());
        if(genre!=null)        post.setGenre(genre); else post.setGenre(this.postDao.findById(id).get().getGenre());
        this.postDao.save(post);        m.addAttribute("post",post);
    }

    public void deletePost(Long id){
        this.postDao.deleteById(id);
    }

}
