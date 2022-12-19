package com.example.moviehub.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ReviewRequest {

    @NotBlank
    private String Content;

    @NotNull
    private int Rating;
}
