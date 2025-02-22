package com.pl.Project.controller;

import com.pl.Project.entity.BookGenre;
import com.pl.Project.entity.Comment;
import com.pl.Project.entity.Post;
import com.pl.Project.service.CommentService;
import com.pl.Project.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;

@Controller
public class PostController {

    @Autowired
    private PostService postService;
    @Autowired
    private CommentService commentService;

    @GetMapping(value = {"postdetails/{id}","postdetails.html/{id}"})
    public String postDetails(Model m, @PathVariable Long id) {
        m.addAttribute("post",postService.getPost(id));
        m.addAttribute("comments",commentService.getCommentByPost(id));
        return "postdetails";
    }

    @GetMapping(value = {"/updatepost/{id}","/updatepost.html/{id}"})
    public String updatepost(Model m, @PathVariable Long id) {
        List<BookGenre> bookGenres = Arrays.asList(BookGenre.values());
        m.addAttribute("post",postService.getPost(id));
        m.addAttribute("genres",bookGenres);
        return "updatepost";
    }

    @PostMapping(value = {"/updatepost.html/{id}","/updatepost/{id}"})
    public String updatepost(@ModelAttribute(value = "post") Post post,@PathVariable("id") Long id, Model m) {
        this.postService.updatePost(post,m,id);

        return "redirect:/store";
    }

    @GetMapping(value = {"/createpost.html","/createpost","/createpost.html/contact"})
    public String createpost(Model model) {
        List<BookGenre> bookGenres = Arrays.asList(BookGenre.values());
        model.addAttribute("commentText", "");
        model.addAttribute("post",new Post());
        model.addAttribute("genres",bookGenres);
        return "/createpost";
    }

    @PostMapping(value = {"/createpost.html","/createpost","/createpost.html/contact"})
    public String postCreate(@ModelAttribute(value = "post") Post post, Model m) {
        m.addAttribute("post",post);
        this.postService.addPost(post);
        return "redirect:/store";
    }

    @GetMapping(value = {"/deletepost.html/{id}","/deletepost/{id}","/deletepost.html/contact/{id}"})
    public String deletepost(@PathVariable("id") String id) {
        this.postService.deletePost(Long.decode(id));
        return "redirect:/store";
    }

    @GetMapping(value = {"/addtocart.html/{id}","/addtocart/{id}","/addtocart.html/contact/{id}"})
    public String addtocart(@PathVariable("id") String id, Principal principal, Model model) {
        this.postService.addtocart(Long.decode(id), principal, model);
        return "redirect:/store";
    }

}
