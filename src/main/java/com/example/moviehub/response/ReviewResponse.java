package com.example.moviehub.response;

import com.example.moviehub.entity.Movie;
import com.example.moviehub.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewResponse {

    private long id;
    private String Content;

    private  int Rating;

    private MovieResponse movie;

    public ReviewResponse(Review review) {
        id = review.getId();
        Content = review.getContent();
        Rating = review.getRating();
        movie = new MovieResponse(review.getMovie());
    }
}
