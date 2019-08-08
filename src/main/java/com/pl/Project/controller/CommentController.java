package com.pl.Project.controller;

import com.pl.Project.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping(value = {"/postdetails/{postId}/{id}"})
    public String deletecomment(@PathVariable("id") Long id, @PathVariable("postId")Long postId) {
        this.commentService.deleteComment(id);
        return "redirect:/postdetails/"+postId;
    }

    @PostMapping(value = {"/postdetails/{postId}","/postdetails.html/{postId}"})
    public String addComment(@ModelAttribute(value = "commentText") String commentText,
                             @PathVariable("postId") Long postId, Model m,  Principal principal) {
        commentService.addComment(commentText,postId,m,principal);
        return "redirect:/postdetails/"+postId;
    }

}
