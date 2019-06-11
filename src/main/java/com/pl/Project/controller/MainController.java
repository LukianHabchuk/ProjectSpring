package com.pl.Project.controller;

import com.pl.Project.dao.PostDao;
import com.pl.Project.dao.UserDao;
import com.pl.Project.entity.Post;
import com.pl.Project.entity.User;
import com.pl.Project.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private PostDao postDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private PostService postService;
//    @Autowired
//    private PasswordEncoder passwordEncoder;


    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm) {
        List<User> users = userDao.findAll();
        for(User u : users){
            if(u.equals(userForm)) return "redirect:/registration";
        }
//        userForm.setPassword(passwordEncoder.encode(userForm.getPassword()));
        userDao.save(userForm);
        return "redirect:/login";
    }

    @GetMapping(value = {"/", "/main.html","/main,","/postdetails.html/main.html"})
    public String welcome() {
        return "main";
    }



    @GetMapping(value = "/admin")
    public String admin(Model model) {
        return "admin";
    }

    @GetMapping(value = {"/store.html", "/store","/postdetails.html/store"})
    public String store(Model model) {
        model.addAttribute("storelist",postDao.findAll());
        return "store";
    }

    @GetMapping(value = "/createpost")
    public RedirectView postCreate(@RequestBody Post post, Model m) {
        m.addAttribute("newpost",post);
        this.postService.addPost(post);
        return new RedirectView("/store");
    }

    @GetMapping(value = {"/postdetails/{id}","/postdetails.html/{id}"})
    public String postDetails(Model m, @PathVariable Long id) {
        m.addAttribute("post",postDao.findById(id).get());
        return "postdetails";
    }

    @GetMapping(value = {"/about.html","/about","/postdetails.html/abot"})
    public String about(Model model) {
        return "about";
    }

    @GetMapping(value = {"/profile.html","/profile","/postdetails.html/profile"})
    public String profile(Model model) {
        return "profile";
    }

    @GetMapping(value = {"/faqs.html","/faqs","/postdetails.html/faqs"})
    public String faqs(Model model) {
        return "faqs";
    }

    @GetMapping(value = {"/contact.html","/contact","/postdetails.html/contact"})
    public String contact(Model model) {
        return "contact";
    }

}
