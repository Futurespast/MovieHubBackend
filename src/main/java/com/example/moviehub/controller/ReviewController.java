package com.example.moviehub.controller;

import com.example.moviehub.request.ReviewRequest;
import com.example.moviehub.response.ReviewResponse;
import com.example.moviehub.service.ReviewService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping("/{Id}")
    public ReviewResponse getReview(@PathVariable long Id) {
        return new ReviewResponse(reviewService.getReview(Id));
    }

    @PutMapping("/{Id}")
    public ReviewResponse updateCourse(@PathVariable long Id, @Valid @RequestBody ReviewRequest reviewRequest){
        return new ReviewResponse(reviewService.updateReview(Id, reviewRequest));
    }

    @DeleteMapping("/{Id}")
    public void deleteCourse(@PathVariable long Id)
    {
        reviewService.deleteReview(Id);
    }
}
