package com.pl.Project.controller;

import com.pl.Project.dao.PostDao;
import com.pl.Project.dao.UserDao;
import com.pl.Project.entity.BookGenre;
import com.pl.Project.entity.Post;
import com.pl.Project.entity.User;
import com.pl.Project.service.PostService;
import com.pl.Project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @GetMapping(value = {"/login","/login.html"})
    public String login() {
        return "login";
    }

    @GetMapping(value = {"/login?succes","/login.html?succes"})
    public String loginSucces() {
        return "main";
    }

    @GetMapping({"/registration","registration.html"})
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @PostMapping({"/registration","registration.html"})
    public String registration(@RequestParam String name, @RequestParam String surname, @RequestParam int age, @RequestParam String login, @RequestParam String password, Model m) {
        List<User> users = userDao.findAll();
        User user = new User(name,surname,login,password,age);
        for(User u : users){
            if(u.equals(user)) return "redirect:/registration";
        }
        user.setPassword(passwordEncoder.encode(password));
        m.addAttribute("userForm",user);
        this.userService.addUser(user);
        return "redirect:/login";
    }

    @GetMapping(value = {"/", "/main.html","/main,","/postdetails.html/main.html"})
    public String welcome() {
        return "main";
    }

    @GetMapping(value = {"/store.html", "/store","/postdetails.html/store"})
    public String store(Model model) {
        model.addAttribute("storelist",postDao.findAll());
        return "store";
    }

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
    public String deletepost(@PathVariable("id") String id, Model model)
    {

        this.postService.deletePost(Long.decode(id));
        return "redirect:/store";
    }

}
