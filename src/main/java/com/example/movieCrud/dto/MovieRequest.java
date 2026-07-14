package com.example.movieCrud.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class MovieRequest {
   
    private Long id;
    @NotBlank
    private String name;
   @NotBlank
	private String actor;
    @NotNull
	private Integer rating;
    @NotBlank
	private String imageLink;  

public Long getId() {
    return id;
}
public void setId(Long id) {
    this.id = id;
}
public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}
public String getActor() {
    return actor;
}
public void setActor(String actor) {
    this.actor = actor;
}
public Integer getRating() {
    return rating;
}
public void setRating(Integer rating) {
    this.rating = rating;
}
public String getImageLink() {
    return imageLink;
}
public void setImageLink(String imageLink) {
    this.imageLink = imageLink;
}
}

