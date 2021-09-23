package edu.kea.kinoxp.models;

import javax.persistence.Id;

public class Movie {
    @Id
    private int idmovies;
    private String title;
    private double price;
    private int length;
    private int age;
    private String genre;
    private String description;
    private String actors; //Måske array
    private String moviePoster;

    public Movie(int idmovies, String title, double price, int length, int age, String genre, String description, String actors, String moviePoster) {
        this.idmovies = idmovies;
        this.title = title;
        this.price = price;
        this.length = length;
        this.age = age;
        this.genre = genre;
        this.description = description;
        this.actors = actors;
        this.moviePoster = moviePoster;
    }

    public Movie(){}

    public int getIdmovies() {
        return idmovies;
    }

    public void setIdmovies(int idmovies) {
        this.idmovies = idmovies;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getMoviePoster() {
        return moviePoster;
    }

    public void setMoviePoster(String moviePoster) {
        this.moviePoster = moviePoster;
    }
}
