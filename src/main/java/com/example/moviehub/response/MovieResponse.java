package com.example.moviehub.response;


import com.example.moviehub.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieResponse {
    private long id;

    private String Title;

    private String Type;


    private String Genre;

    private String Description;

    public MovieResponse (Movie movie){

        id= movie.getId();
        Title = movie.getTitle();
        Type= movie.getType();
        Genre = movie.getGenre();
        Description = movie.getDescription();
    }
}
