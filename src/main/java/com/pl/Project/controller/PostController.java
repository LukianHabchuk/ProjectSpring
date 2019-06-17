package com.pl.Project.controller;

import com.pl.Project.dao.PostDao;
import com.pl.Project.entity.BookGenre;
import com.pl.Project.entity.Post;
import com.pl.Project.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class PostController {

    @Autowired
    private PostDao postDao;
    @Autowired
    private PostService postService;

    @GetMapping(value = {"postdetails/{id}","postdetails.html{id}"})
    public String postDetails(Model m, @PathVariable Long id) {
        m.addAttribute("post",postDao.findById(id).get());
        return "postdetails";
    }

    @GetMapping(value = {"/updatepost/{id}","/updatepost.html/{id}"})
    public String updatePost(Model m, @PathVariable Long id) {
        m.addAttribute("post",postDao.findById(id).get());
        return "updatepost";
    }

    @PostMapping(value = {"/updatepost.html","/updatepost"})
    public String updatePost(@ModelAttribute(value = "post") Post post,
                                   Model m) {
        this.postService.updatePost(post,m);

        return "redirect:/store";
    }

    @GetMapping(value = {"/createpost.html","/createpost","/createpost.html/contact"})
    public String createpost(Model model) {
        model.addAttribute("post",new Post());
        return "createpost";
    }

    @PostMapping(value = {"/createpost.html","/createpost","/createpost.html/contact"})
    public String postCreate(@ModelAttribute(value = "post") Post post,
                                   Model m) {
        m.addAttribute("post",post);
        this.postService.addPost(post);
        return "redirect:/store";
    }

    @GetMapping(value = {"/deletepost.html/{id}","/deletepost/{id}","/deletepost.html/contact/{id}"})
    public String deletepost(@PathVariable("id") String id, Model model) {

        this.postService.deletePost(Long.decode(id));
        return "redirect:/store";
    }

}
