package com.marvel.springbootlibrary2.requestmodels;

import lombok.Data;

@Data

public class AdminQuestionRequest {
    private Long id;
    private  String response;

    public Long getId() {
        return id;
    }

    public String getResponse() {
        return response;
    }
}
