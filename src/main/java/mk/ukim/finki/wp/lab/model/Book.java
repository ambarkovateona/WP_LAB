package mk.ukim.finki.wp.lab.model;

import lombok.Data;

@Data
public class Book {

    private  String title;
    private String genre;
    private double averageRating;

    public Book(String title, String genre, double averageRating) {
        this.averageRating = averageRating;
        this.genre = genre;
        this.title = title;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
