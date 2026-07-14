package com.example.movieCrud.repository;
import com.example.movieCrud.entity.Movie;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findAll();
    List<Movie> findByName(String name);
    List<Movie> findByActor(String actor);
    List<Movie> findByRating(Integer rating);
}
