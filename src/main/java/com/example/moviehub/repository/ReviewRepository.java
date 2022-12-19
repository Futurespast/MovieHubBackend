package com.example.moviehub.repository;

import com.example.moviehub.entity.Review;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

@Repository
public interface ReviewRepository extends CrudRepository<Review,Long> {
    List<Review> findAllByMovieId(long id);

    @Transactional
    void deleteAllById(long id);
}
