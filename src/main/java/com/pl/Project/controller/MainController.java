package com.pl.Project.controller;

import com.pl.Project.dao.PostDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @Autowired
    private PostDao postDao;

    @GetMapping(value = {"/", "/main.html","/main,","/postdetails.html/main.html"})
    public String welcome() {
        return "main";
    }

    @GetMapping(value = {"/store.html", "/store","/postdetails.html/store"})
    public String store(Model model) {
        model.addAttribute("storelist",postDao.findAll());
        return "store";
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
