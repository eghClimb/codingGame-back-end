package com.maltem.codingGame.Repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import com.maltem.codingGame.entity.Movie;
import org.springframework.stereotype.Repository;


import java.io.*;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository

public class MovieRepository {

    final String JSON_DATA_FILE = "/movies.json";

    public List<Movie> listAll() throws  IOException {

        File file = rtrvFile();

        try (FileReader fr = new FileReader(file)) {

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            // construct Type that tells Gson about the generic type
            Type dtoListType = new TypeToken<List<Movie>>() {
            }.getType();
            List<Movie> dtos = gson.fromJson(fr, dtoListType);
            fr.close();
            // If it was an empty one create initial list
            if (null == dtos) {
                dtos = new ArrayList<Movie>();
            }
            return dtos;
        }

    }



    public Movie addMovie(Movie movie) throws IOException  {

                File file =  rtrvFile();
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                List<Movie> dtos = listAll();
                // Add new item to the list
                dtos.add(movie);
                // No append replace the whole file
                FileWriter fw  = new FileWriter(file);
                gson.toJson(dtos, fw);
                fw.close();
                return movie;
        }
        // since i'm not given the Id in the initial json file ... going to consider the title as an identifier
    public void deleteByTitle(String movieTitle) throws IOException  {

        File file =  rtrvFile();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<Movie> dtos = listAll();
            List<Movie> moviesToRemove = dtos.stream().filter(x ->  movieTitle.equals(x.getTitle()))
            .collect(Collectors.toList());
            dtos.removeAll(moviesToRemove);
            // No append replace the whole file
            FileWriter fw  = new FileWriter(file);
            gson.toJson(dtos, fw);
            fw.close();

    }

    // since i'm not given the Id in the initial json file ... going to consider the title as an identifier
    public List<Movie> findByTitle(String movieTitle) throws IOException  {
        File file =  rtrvFile();
        List<Movie> dtos = listAll();
            // checks if the movie title includes a given sub String
            List<Movie> fetchedMovies = dtos.stream().filter(x -> x.getTitle().toLowerCase().indexOf(movieTitle.toLowerCase()) !=-1)
                    .collect(Collectors.toList());
           return fetchedMovies;

    }

    // since i'm not given the Id in the initial json file ... going to consider the title as an identifier
    public List<Movie> findByDirector(String movieDirector) throws IOException  {
        File file =  rtrvFile();
        List<Movie> dtos = listAll();
            // checks if the movie title includes a given sub String
            List<Movie> fetchedMovies = dtos.stream().filter(x -> x.getDirector().toLowerCase().indexOf(movieDirector.toLowerCase()) !=-1)
                    .collect(Collectors.toList());
            return fetchedMovies;

    }

    // since i'm not given the Id in the initial json file ... going to consider the title as an identifier
    public List<Movie> findByType(String movieType) throws IOException  {
        File file =  rtrvFile();
        List<Movie> dtos = listAll();
        // checks if the movie title includes a given sub String
        List<Movie> fetchedMovies = dtos.stream().filter(x -> x.getType().toLowerCase().indexOf(movieType.toLowerCase()) !=-1)
                .collect(Collectors.toList());
        return fetchedMovies;

    }
    // since i'm not given the Id in the initial json file ... going to consider the title as an identifier
    public List<Movie> findByReleaseDate(String releaseDate) throws IOException  {
        File file =  rtrvFile();
        List<Movie> dtos = listAll();
        List<Movie> fetchedMovies = dtos.stream().filter(x -> x.getReleaseDate().equals(releaseDate))
                .collect(Collectors.toList());
        return fetchedMovies;

    }

    public void updateMovie(Movie movie) throws IOException  {

        // first need to remove previous version of movie
        deleteByTitle(movie.getTitle());
        // then add the new version
        addMovie(movie);

    }

    // get file from classpath
    public File rtrvFile()
            throws FileNotFoundException {
        URL fileUrl = getClass().getResource(JSON_DATA_FILE);
        return new File(fileUrl.getFile());
    }


}
