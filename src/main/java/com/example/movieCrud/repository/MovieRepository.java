package com.example.movieCrud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.movieCrud.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

	

}
