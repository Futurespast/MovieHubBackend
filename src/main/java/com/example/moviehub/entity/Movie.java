package com.example.moviehub.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import java.util.List;

@Entity
@Table(name="Movies")
@Getter
@Setter
@NoArgsConstructor
public class Movie {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "Title", nullable=false)
    private String Title;

    @Column(name="Type", nullable = false)
    private String Type;

    @Column(name="Genre", nullable = false)
    private String Genre;

}
