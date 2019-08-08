package com.pl.Project.service;

import com.pl.Project.dao.CommentDao;
import com.pl.Project.dao.PostDao;
import com.pl.Project.dao.UserDao;
import com.pl.Project.entity.Comment;
import com.pl.Project.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentDao commentDao;
    @Autowired
    private PostDao postDao;
    @Autowired
    private UserService userService;

    public Comment getComment(Long id){
        return commentDao.findById(id).get();
    }

    public List<Comment> getCommentByPost(Long postIid){
        return commentDao.findByPostId(postIid);
    }

    public List<Comment> getCommentByUser(String userLogin){
        return commentDao.findByUserLogin(userLogin);
    }

    public List<Comment> getComments(){
        List<Comment> comments = new ArrayList<>();
        this.commentDao.findAll().forEach(comments::add);
        return comments;
    }

    public void addComment(String commentText, Long postid, Model m, Principal principal){
        String actualDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
        Post actualPost = postDao.findById(postid).get();
        String login = userService.getUser(principal.getName()).getLogin();
        Comment comment = new Comment(commentText,actualDate,login,postid);
        commentDao.save(comment);

        List<Comment> listOfCommentsFromPost = actualPost.getCommentList();
        listOfCommentsFromPost.add(comment);
        actualPost.setCommentList(listOfCommentsFromPost);
        postDao.save(actualPost);

        m.addAttribute("post",actualPost);
        m.addAttribute("comments",getCommentByPost(actualPost.getId()));
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
