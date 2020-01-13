package com.maltem.codingGame.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    // Use the sequence that is defined above:
  //  @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq")

    private String title;
    private String director ;
    private String releaseDate ;
    private String type ;

}
