package com.example.moviehub.service;

import com.example.moviehub.entity.Review;
import com.example.moviehub.exception.ResourceNotFoundException;
import com.example.moviehub.repository.ReviewRepository;
import com.example.moviehub.request.ReviewRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    public Review getReview(long Id)
    {
        Review review = reviewRepository.findById(Id).orElseThrow(()->new ResourceNotFoundException("review id not found"));
        return review;
    }

    public Review updateReview(long Id, ReviewRequest reviewRequest){
        if(reviewRepository.existsById(Id))
        {
            Review reviewToBeUpdated = new Review(reviewRequest);
            reviewToBeUpdated.setId(Id);
            return reviewRepository.save(reviewToBeUpdated);
        }
        else{
            throw new ResourceNotFoundException("course id not found");
        }
    }

    public void deleteReview(long Id){
        if(reviewRepository.existsById(Id)){
            reviewRepository.deleteById(Id);
        }
        else{
            throw new ResourceNotFoundException("review id not found");

        }
    }

}
