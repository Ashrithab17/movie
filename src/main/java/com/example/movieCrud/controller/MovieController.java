package com.example.movieCrud.controller;

import java.util.List;
import com.example.movieCrud.entity.Movie;
import com.example.movieCrud.dto.MovieRequest;
import com.example.movieCrud.service.MovieService;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/movies")

public class MovieController {
    private final MovieService service;

    public MovieController(MovieService service) {
        this.service = service;
    }
@Operation(summary = "Create a new movie")
    @PostMapping
    public String add(@RequestBody MovieRequest request) {
        return service.addMovie(request);
    }

    @Operation(summary = "Get all movies")
    @GetMapping
    public List<Movie> getAll() {
        return service.getAllMovies();
    }

    @Operation(summary = "Get a movie by ID")
    @GetMapping("/{id}")
    public Movie getById(@PathVariable Long id) {
        return service.getMovieById(id);
    }

    @Operation(summary = "Update a movie")
    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @RequestBody MovieRequest request) {
        return service.updateMovie(id, request);
    }

    @Operation(summary = "Delete a movie")
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return service.deleteMovie(id);
    }
    @Operation(summary = "get a actor")
    @GetMapping("/actor/{actor}")
    public List<Movie> ByActor(@PathVariable String actor){
        return service.getMoviesByActor(actor);
    }
     @Operation(summary = "get a movie rating")
    @GetMapping("/rating/{rating}")
    public List<Movie> ByRating(@PathVariable Integer rating){
        return service.getMoviesByRating(rating);
    }
     @Operation(summary = "get a movie name")
    @GetMapping("/name/{name}")
    public List<Movie> ByName(@PathVariable String name){
        return service.getMoviesByName(name );
    }
}



