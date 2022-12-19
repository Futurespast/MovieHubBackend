package com.example.moviehub.entity;


import com.example.moviehub.request.ReviewRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "Reviews")
@Getter
@Setter
@NoArgsConstructor
public class Review {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="Content", nullable = false)
    private String Content;

    @Column(name="rating" , nullable = false)
    private int Rating;

    @ManyToOne(optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name="movie_id")
    private Movie movie;

    public Review (ReviewRequest reviewRequest){
        Content=reviewRequest.getContent();
        Rating=reviewRequest.getRating();

    }
}
