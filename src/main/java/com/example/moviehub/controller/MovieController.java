package com.example.moviehub.controller;

import com.example.moviehub.entity.Movie;
import com.example.moviehub.entity.Review;
import com.example.moviehub.request.MovieRequest;
import com.example.moviehub.request.ReviewRequest;
import com.example.moviehub.response.MovieResponse;
import com.example.moviehub.response.ReviewResponse;
import com.example.moviehub.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/Movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{id}/reviews")
    public ReviewResponse addReview(
            @PathVariable long id,
            @Valid @RequestBody ReviewRequest reviewRequest
    ){
        return new ReviewResponse(movieService.addReview(id, reviewRequest));
    }

    @GetMapping("/{Id}/reviews")
    public List<ReviewResponse> getAllReviews(@PathVariable long Id){
        List<Review> reviews = movieService.getAllReviews(Id);
        List<ReviewResponse> reviewResponses = new ArrayList<>();
        for(int i=0; i < reviews.size(); i++){
            reviewResponses.add(new ReviewResponse(reviews.get(i)));
        }

        return reviewResponses;
    }

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

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public MovieResponse addMovie(@Valid @RequestBody MovieRequest movieRequest){
        Movie savedMovie = movieService.addMovie(movieRequest);
        return new MovieResponse(savedMovie);
    }

    @PutMapping("/{id}")
    public MovieResponse updateMovie(@PathVariable long id, @Valid @RequestBody MovieRequest movieRequest){
        Movie updatedMovie = movieService.updateMovie(id, movieRequest);
        return new MovieResponse(updatedMovie);
    }
    @DeleteMapping("/{id}")
    public void deleteMovie (@PathVariable long id){
        movieService.deleteMovie(id);
    }
}

