package com.example.movieCrud.service;
import com.example.movieCrud.dto.MovieRequest;
import com.example.movieCrud.entity.Movie;
import java.util.List;

public interface MovieService {
    String addMovie(MovieRequest request); 
    String updateMovie(Long id, MovieRequest request);
    String deleteMovie(Long id);

    List<Movie> getAllMovies();
    Movie getMovieById(Long id);
    List<Movie> getMoviesByActor(String actor);
    List<Movie> getMoviesByRating(Integer rating);
    List<Movie> getMoviesByName(String name);

}
