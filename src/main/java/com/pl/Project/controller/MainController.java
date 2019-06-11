package com.pl.Project.controller;

import com.pl.Project.dao.PostDao;
import com.pl.Project.dao.UserDao;
import com.pl.Project.entity.User;
import com.pl.Project.service.PostService;
import com.pl.Project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private PostDao postDao;
    @Autowired
    private UserDao userDao;
    private PostService postService;
    private UserService userService;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm, Model model) {
        List<User> users = userDao.findAll();
        for(User u : users){
            if(u.equals(userForm)) return "redirect:/registration";
        }
        userDao.save(userForm);
        return "redirect:/login";
    }

    @GetMapping(value = "/login")
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Username or password is incorrect.");
        }

        if (logout != null) {
            model.addAttribute("message", "Logged out successfully.");
        }

        return "login";
    }

    @GetMapping(value = {"/", "/main.html","/main"})
    public String welcome(Model model) {

        return "main";
    }

    @GetMapping(value = "/admin")
    public String admin(Model model) {
        return "admin";
    }

    @GetMapping(value = {"/store.html", "/store"})
    public String store(Model model) {
        model.addAttribute("store",postDao.findAll());
        return "store";
    }

    @GetMapping(value = "/createpost")
    public String postCreate(Model m, Principal principal) {
//        m.addAttribute("post", postDao.findById(principal.));
        //zwrócenie nazwy widoku profilu użytkownika - profile.html
        return "profile";
    }

    @GetMapping(value = {"/postdetails","/postdetails.html"})
    public String postDetails(Model m, Principal principal) {
        m.addAttribute("post", postDao.findById(Long.decode(principal.getName())));
        //zwrócenie nazwy widoku profilu użytkownika - profile.html
        return "postdetails";
    }

    @GetMapping(value = {"/about.html","/about"})
    public String about(Model model) {
        return "about";
    }

    @GetMapping(value = {"/profile.html","/profile"})
    public String profile(Model model) {
        return "profile";
    }

}
