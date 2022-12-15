package com.example.moviehub.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class MovieRequest {

    @NotBlank
    private String Title;

    @NotBlank
    private String Type;

    @NotBlank
    private String Genre;

    @NotBlank
    private String Description;



}
