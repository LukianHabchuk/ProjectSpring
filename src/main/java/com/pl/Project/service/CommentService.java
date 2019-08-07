package com.pl.Project.service;

import com.pl.Project.dao.CommentDao;
import com.pl.Project.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentDao commentDao;

    public Comment getComment(Long id){
        return commentDao.findById(id).get();
    }

    public List<Comment> getCommentByPost(Long postIid){
        return commentDao.findByPostId(postIid);
    }

    public List<Comment> getCommentByUser(Long userIid){
        return commentDao.findByUserId(userIid);
    }

    public List<Comment> getComments(){
        List<Comment> comments = new ArrayList<>();
        this.commentDao.findAll().forEach(comments::add);
        return comments;
    }

    public void addComment(Comment comment){
        commentDao.save(comment);
    }

    public void updateComment(Comment comment, Model m){
        if(comment!=null){
            this.commentDao.save(comment);
            m.addAttribute("comment",comment);
        }
    }

    public void deleteComment(Long id){
        this.commentDao.deleteById(id);
    }
}
