package com.example.movieCrud.dto;

public class Dashboardmovie {
    private Long id;
    private String name;
    private String actor;
    private Integer rating;
    private String imageLink;

public  Dashboardmovie(Long id, String name, String actor, Integer rating, String imageLink) {
    this.id = id;
    this.name = name;
    this.actor = actor;
    this.rating = rating;
    this.imageLink = imageLink;
}
 public Long getId() {
    return id;}
public String getName() {
    return name;
}
public String getActor() {
    return actor;
}
public Integer getRating() {
    return rating;
}
public String getImageLink() {
    return imageLink;
}
}