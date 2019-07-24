package com.pl.Project.controller;

import com.pl.Project.dao.PostDao;
import com.pl.Project.dao.UserDao;
import com.pl.Project.service.PostService;
import com.pl.Project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class MainController {

    public final String MAINPAGE="http://localhost:8080/main.html";

    @Autowired
    private PostDao postDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserService userService;
    @Autowired
    private PostService postService;

    @GetMapping(value = {"/", "/main.html","/main,","/postdetails.html/main.html"})
    public String welcome() {
        return "main";
    }

    @GetMapping(value = {"/store.html", "/store","/postdetails.html/store"})
    public String store(Model model, @RequestParam(required = false) String query) {
        model.addAttribute("storelist",postService.search(query));
        return "store";
    }

//    @PostMapping(value = {"/store.html", "/store","/postdetails.html/store"})
//    public String store(@RequestParam String query, Model model) {
//        model.addAttribute("storelist",postService.getPostList());
//        return "store";
//    }

    @GetMapping(value = {"about.html","about","postdetails.html/about"})
    public String about(Model model) {
        return "about";
    }

    @GetMapping(value = {"/profile.html","/profile","/postdetails.html/profile"})
    public String profile(Model model, Principal principal) {
        model.addAttribute("curentuser",userDao.findByLogin(principal.getName()));
        return "profile";
    }

    @PostMapping(value = {"/profile.html","/profile","/postdetails.html/profile"})
    public String profile(@RequestParam String name,
                                @RequestParam String surname,
                                @RequestParam int age,
                                @RequestParam String login,
                                @RequestParam String password,
                                Principal principal, Model model) {
        userService.updateUser(userDao.findByLogin(principal.getName()).getId(),name,surname,login,password,age,model);
        return "redirect:/profile";
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
