package com.maltem.codingGame.controller;

import com.maltem.codingGame.entity.Movie;
import com.maltem.codingGame.error.MovieNotFoundException;
import com.maltem.codingGame.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class MovieController {
    @Autowired
    MovieService movieService;

    @GetMapping("/movies")
    List<Movie>  getAllMovies(){
        return movieService.listAll();
    }

    // Save
    //return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/movies")
    Movie addMovie(@RequestBody Movie newMovie) {
        return movieService.addMovie(newMovie);
    }

    @DeleteMapping("/movies/{title}")
    void deleteByTitle(@PathVariable String title) {
        movieService.deleteByTitle(title);
    }

    // Find by title
    @GetMapping("/movies/titles/{title}")
    List<Movie> findByTitle(@PathVariable String title) {
        return movieService.findMovieByTitle(title)
                .orElseThrow(() -> new MovieNotFoundException(title));
    }

    // Find by director
    @GetMapping("/movies/directors/{director}")
    List<Movie> findByDirector(@PathVariable String director) {
        return movieService.findMovieByDirector(director)
                .orElseThrow(() -> new MovieNotFoundException(director));
    }

    // Find by releaseDate
    @GetMapping("/movies/releaseDates/{releaseDate}")
    List<Movie> findByReleaseDate(@PathVariable String releaseDate) {
        return movieService.findMovieByReleaseDate(releaseDate)
                .orElseThrow(() -> new MovieNotFoundException(releaseDate));
    }

    // Find by type
    @GetMapping("/movies/types/{type}")
    List<Movie> findByType(@PathVariable String type) {
        return movieService.findMovieByType(type)
                .orElseThrow(() -> new MovieNotFoundException(type));
    }
    @PutMapping("/movies")
    Movie saveOrUpdate(@RequestBody Movie updateMovie) {
        System.out.println(updateMovie);
        return movieService.updateMovie(updateMovie);
    }

}
