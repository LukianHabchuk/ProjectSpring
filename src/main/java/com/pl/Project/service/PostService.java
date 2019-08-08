package com.pl.Project.service;

import com.pl.Project.dao.PostDao;
import com.pl.Project.dao.UserDao;
import com.pl.Project.entity.BookGenre;
import com.pl.Project.entity.Post;
import com.pl.Project.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    private PostDao postDao;
    @Autowired
    private UserDao userDao;

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

    public void updatePost(Post post, Model m,Long id){
        if(post!=null){
            this.postDao.save(post);
            m.addAttribute("post",post);
        }
    }

    public void deletePost(Long id){
        this.postDao.deleteById(id);
    }

    public List<Post> search(String query) {
        List<Post> posts = (List<Post>) postDao.findAll();
        return query != null && !query.isEmpty() ?
                posts.stream()
                        .filter(post ->post.getTitle().toLowerCase()
                        .matches(".*"+query.toLowerCase()+".*"))
                        .collect(Collectors.toList()) : posts;
    }

    public void addtocart(Long id, Principal principal, Model model) {
        User user = userDao.findByLogin(principal.getName());
        user.getCart().add(this.postDao.findById(id).get());
        userDao.save(user);
        model.addAttribute("cart",user.getCart());
    }

    public Set<Post> getCart(User user) {
        return user.getCart();
    }
}
