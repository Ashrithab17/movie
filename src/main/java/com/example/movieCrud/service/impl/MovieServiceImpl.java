package com.example.movieCrud.service.impl;
import com.example.movieCrud.dto.MovieRequest;
import com.example.movieCrud.entity.Movie;
import com.example.movieCrud.service.MovieService;
import com.example.movieCrud.repository.MovieRepository;


import jakarta.transaction.Transactional;

import com.example.movieCrud.repository.MovieRepository;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
@Transactional
public class MovieServiceImpl implements MovieService {
    private final MovieRepository repo;

    public MovieServiceImpl(MovieRepository repo) {
        this.repo = repo;
    }

    @Override
    public String addMovie(MovieRequest request) {
        Movie movie = new Movie();
        movie.setName(request.getName());
        movie.setActor(request.getActor());
        movie.setRating(request.getRating());
        movie.setImageLink(request.getImageLink());
        repo.save(movie);
        // Implementation for adding a movie
        return "Movie added successfully";
    }

    @Override
    public String updateMovie(Long id , MovieRequest request) {
        Movie movie = repo.findById(id).orElseThrow(() -> new RuntimeException("Movie not found"));
        movie.setName(request.getName());
        movie.setActor(request.getActor());
        movie.setRating(request.getRating());
        movie.setImageLink(request.getImageLink());
        repo.save(movie);

        // Implementation for updating a movie
        return "Movie updated successfully";
    }

    @Override
    public String deleteMovie(Long id) {
        repo.deleteById(id);
        // Implementation for deleting a movie
        return "Movie deleted successfully";
    }

    @Override
    public List<Movie> getAllMovies() {

        // Implementation for retrieving all movies
        return repo.findAll();
    }

    @Override
    public Movie getMovieById(Long id) {
        // Implementation for retrieving a movie by ID
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Movie not found"));
    }

    @Override
    public List<Movie> getMoviesByActor(String actor) {
        // Implementation for retrieving movies by actor
        return repo.findByActor(actor);
    }

    @Override
    public List<Movie> getMoviesByRating(Integer rating) {
        // Implementation for retrieving movies by rating
        return repo.findByRating(rating); // Placeholder, implement as needed
    }

    @Override
    public List<Movie> getMoviesByName(String name) {
        // Implementation for retrieving movies by name
        return repo.findByName(name); // Placeholder, implement as needed
    }
    
    
}
