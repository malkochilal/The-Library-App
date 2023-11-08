package com.marvel.springbootlibrary2.entity;
import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name="book")
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="title")
    private String title;
    @Column(name="author")
    private String author;
    @Column(name="description")
    private String description;
    @Column(name="copies")
    private  int copies;
    @Column(name="copies_available")
    private int copiesAvailable;
    @Column(name="category")
    private String category;
    @Column(name="img")
    private String img;


    public Long getId() {
        return id;
    }

    public void setCopiesAvailable(int copiesAvailable) {
        this.copiesAvailable = copiesAvailable;
    }

    public int getCopiesAvailable() {
        return copiesAvailable;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public int getCopies() {
        return copies;
    }

    public String getCategory() {
        return category;
    }

    public String getImg() {
        return img;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
