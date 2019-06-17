package com.pl.Project.controller;

import com.pl.Project.dao.PostDao;
import com.pl.Project.entity.BookGenre;
import com.pl.Project.entity.Post;
import com.pl.Project.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class PostController {

    @Autowired
    private PostDao postDao;
    @Autowired
    private PostService postService;

    @GetMapping(value = {"/postdetails/{id}","/postdetails.html/{id}"})
    public String postDetails(Model m, @PathVariable Long id) {
        m.addAttribute("post",postDao.findById(id).get());
        return "/postdetails";
    }

    @GetMapping(value = {"/updatepost/{id}","/updatepost.html/{id}"})
    public String updatePost(Model m, @PathVariable Long id) {
        m.addAttribute("post",postDao.findById(id).get());
        return "/updatepost";
    }

    @PostMapping(value = {"/updatepost.html","/updatepost"})
    public RedirectView updatePost(@RequestParam("title") String title,
                                   @RequestParam("author") String author,
                                   @RequestParam("price") Double price,
                                   @RequestParam("img") String img,
                                   @RequestParam("genre") BookGenre genre,
                                   @RequestParam("id") Long id,
                                   Model m) {
        this.postService.updatePost(id,title,author,price,img,genre,m);

        return new RedirectView("store");
    }

    @GetMapping(value = {"/createpost.html","/createpost","/createpost.html/contact"})
    public String createpost(Model model) {
        return "createpost";
    }

    @PostMapping(value = {"/createpost.html","/createpost","/createpost.html/contact"})
    public RedirectView postCreate(@RequestParam("title") String title,
                                   @RequestParam("author") String author,
                                   @RequestParam("price") Double price,
                                   @RequestParam("img") String img,
                                   @RequestParam("genre") BookGenre genre,
                                   Model m) {
        Post p = new Post(title,author,price,img,genre);
        m.addAttribute("post",p);
        this.postService.addPost(p);
        return new RedirectView("store");
    }

    @GetMapping(value = {"/deletepost.html/{id}","/deletepost/{id}","/deletepost.html/contact/{id}"})
    public String deletepost(@PathVariable("id") String id, Model model) {

        this.postService.deletePost(Long.decode(id));
        return "redirect:/store";
    }

}
