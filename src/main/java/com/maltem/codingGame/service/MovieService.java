package com.maltem.codingGame.service;

import com.maltem.codingGame.Repository.MovieRepository;
import com.maltem.codingGame.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> listAll(){
        List<Movie>  movieList = null;
        try {
            movieList= movieRepository.listAll();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return movieList;
    }
    public Movie addMovie(Movie movie)  {
        Movie returnedMovie = null;
        try {
            returnedMovie= movieRepository.addMovie(movie);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return returnedMovie;
    }

    public void deleteByTitle(String title){
        try {
            movieRepository.deleteByTitle(title);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Optional<List<Movie>> findMovieByTitle(String title){
        List<Movie> movies = null;

        try {
            movies = movieRepository.findByTitle(title);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Optional.of(movies);
    }

    public Optional<List<Movie>>  findMovieByDirector(String director){
        List<Movie> movies = null;

        try {
            movies = movieRepository.findByDirector(director);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Optional.of(movies);
    }

    public Optional<List<Movie>>  findMovieByReleaseDate(String releaseDate){
        List<Movie> movies = null;

        try {
            // dates are in json files using slash
            // however having the slash in path is misleading ... sort of new path
            // dates which will be passed to url will be using - instead .. so need to be converted to original
            String[] split = releaseDate.split("-");
            releaseDate=split[0]+"/"+split[1]+"/"+split[2];

            movies = movieRepository.findByReleaseDate(releaseDate);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Optional.of(movies);
    }

    public Optional<List<Movie>>  findMovieByType(String type){
        List<Movie> movies = null;

        try {
            movies = movieRepository.findByType(type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Optional.of(movies);
    }

    public Movie updateMovie(Movie movie){
        try {
            movieRepository.updateMovie(movie);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return movie;
    }






}
