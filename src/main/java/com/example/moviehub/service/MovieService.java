package com.example.moviehub.service;

import com.example.moviehub.entity.Movie;
import com.example.moviehub.entity.Review;
import com.example.moviehub.exception.ResourceNotFoundException;
import com.example.moviehub.repository.MovieRepository;
import com.example.moviehub.repository.ReviewRepository;
import com.example.moviehub.request.MovieRequest;
import com.example.moviehub.request.ReviewRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired

    MovieRepository movieRepository;

    @Autowired
    ReviewRepository reviewRepository;

    public Review addReview(long id, ReviewRequest reviewRequest) {
    Movie movie = movieRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Movie id could not be found"));
    Review reviewToBeSaved= new Review(reviewRequest);
    reviewToBeSaved.setMovie(movie);
    return reviewRepository.save(reviewToBeSaved);
    }

    public List<Review> getAllReviews(long id) {
        return reviewRepository.findAllByMovieId(id);
    }

    public List<Movie> getAllMovies() {
        return (List<Movie>) movieRepository.findAll();
    }

    public Movie getMovieById(long id) {
        return movieRepository.findById(id).orElse(null);
    }


    public Movie addMovie(MovieRequest movieRequest) {
        Movie movie = new Movie(movieRequest);
        return movieRepository.save(movie);
    }

    public Movie updateMovie(long id, MovieRequest movieRequest) {
    movieRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("teacher id is not found"));
    Movie movieTobeUpdated = new Movie(movieRequest);
    movieTobeUpdated.setId(id);
    return movieRepository.save(movieTobeUpdated);
    }

    public void deleteMovie(long id) {
        if(movieRepository.existsById(id)){
            movieRepository.deleteById(id);
        }
        else {
            throw new ResourceNotFoundException("movie id not found");
        }
    }
}

