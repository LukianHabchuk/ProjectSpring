package com.pl.Project.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Order {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "customerId")
    private Long customerId;//komu sprzedano
    @Column(name = "employeeId")
    private Long employeeId;//kto sprzedal
    @Column(name = "books")
    private long[] books;//lista numerow ksiazek jakie byly sprzedano

    public Order() {
    }

    public Order(Long customerId, Long employeeId, long[] books) {
        this.customerId = customerId;
        this.employeeId = employeeId;
        this.books = books;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public long[] getBooks() {
        return books;
    }

    public void setBooks(long[] books) {
        this.books = books;
    }
}
