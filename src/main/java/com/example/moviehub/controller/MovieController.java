package com.example.moviehub.controller;

import com.example.moviehub.entity.Movie;
import com.example.moviehub.response.MovieResponse;
import com.example.moviehub.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/Movies")
public class MovieController {
    @Autowired
    private MovieService movieService;
    @GetMapping
    public List<MovieResponse> getAllMovies() {
        List<Movie> movies = movieService.getAllMovies();
        List<MovieResponse> movieResponses = new ArrayList<>();
        movies.forEach(movie -> {
            MovieResponse movieResponse = new MovieResponse(movie);
            movieResponses.add(movieResponse);
        });
        return movieResponses;
    }

    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable long id) {
        return movieService.getMovieById(id);
    }
}
