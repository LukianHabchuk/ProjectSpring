package com.pl.Project.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Post {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String author;
    private double price;
    private String img;
    private BookGenre genre;
    @ManyToMany
    private List<Comment> commentList;

    public Post() {
    }

    public Post(String title, String author, double price, String img, BookGenre genre, List<Comment> commentList) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.img = img;
        this.genre = genre;
        this.commentList = commentList;
    }

    public Post(String title, String author, double price, String img, BookGenre genre) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.img = img;
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public BookGenre getGenre() {
        return genre;
    }

    public void setGenre(BookGenre genre) {
        this.genre = genre;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
}
