package com.marvel.springbootlibrary2.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="payment")
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="user_email")
    private String userEmail;
    @Column(name="amount")
    private double amount;

    public Long getId() {
        return id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public double getAmount() {
        return amount;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
