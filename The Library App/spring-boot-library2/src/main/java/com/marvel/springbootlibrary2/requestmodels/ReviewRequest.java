package com.marvel.springbootlibrary2.requestmodels;

import lombok.Data;

import java.util.Optional;

@Data
public class ReviewRequest {
    private double rating;
    private Long bookId;
    private Optional<String> reviewDescription;


    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getBookId() {
        return bookId;
    }

    public double getRating() {
        return rating;
    }

    public Optional<String> getReviewDescription() {
        return reviewDescription;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setReviewDescription(Optional<String> reviewDescription) {
        this.reviewDescription = reviewDescription;
    }
}
