package com.marvel.springbootlibrary2.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="checkout")
@Data
public class Checkout {
    public Checkout(){}
    public Checkout(String userEmail,String checkoutDate,String returnDate,Long bookId){
        this.userEmail=userEmail;
        this.checkoutDate=checkoutDate;
        this.returnDate=returnDate;
        this.bookId=bookId;
    }
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="user_email")
    private String userEmail;

    @Column(name="checkout_date")
    private String checkoutDate;

    @Column(name="return_date")
    private String returnDate;
    @Column(name="book_id")
    private Long bookId;

    public Long getId() {
        return id;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getCheckoutDate() {
        return checkoutDate;
    }
}
