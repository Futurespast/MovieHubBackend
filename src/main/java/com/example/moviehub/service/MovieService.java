package com.example.moviehub.service;

import com.example.moviehub.entity.Movie;
import com.example.moviehub.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    public List<Movie> getAllMovies() {
        return (List<Movie>) movieRepository.findAll();
    }

    public Movie getMovieById(long id) {
        return movieRepository.findById(id).orElse(null);
    }
}

