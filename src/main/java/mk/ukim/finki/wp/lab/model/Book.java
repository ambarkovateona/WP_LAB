package mk.ukim.finki.wp.lab.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Book {

    private  String title;
    private String genre;
    private double averageRating;
    private Long id;
    private Author author;

    public Book(String title, String genre, double averageRating) {
        this.averageRating = averageRating;
        this.genre = genre;
        this.title = title;
        this.id = (long) (Math.random() * 1000);
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
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
}
