package com.maltem.codingGame;

import com.maltem.codingGame.Repository.MovieRepository;
import com.maltem.codingGame.entity.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

@SpringBootTest
class CodingGameApplicationTests {

	@Test
	void contextLoads() {

	}
	@Test
	void testRetrievingAllContent(){
		MovieRepository movieRepository = new MovieRepository();
		List<Movie> movies = null;
		try {
			movies = movieRepository.listAll();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("here goes the movies "+ movies);
	}

	@Test
	void testingAddMovie() throws IOException {
		MovieRepository movieRepository = new MovieRepository();
		List<Movie> movies = movieRepository.listAll();
		System.out.println("here goes the movies before adding "+ movies);

		Movie movie = new Movie();
		movie.setTitle("egh");
		movie.setDirector("egh");
		movie.setReleaseDate("21/05/1990");
		movie.setType("egh");
		System.out.println("the movie am about to insert is .."+movie);
		movieRepository.addMovie(movie);
		movies = movieRepository.listAll();
		System.out.println("here goes the movies after adding "+ movies);

	}
	@Test
	void TestDeleteByTitle() throws IOException {
		MovieRepository movieRepository = new MovieRepository();
		List<Movie> movies = movieRepository.listAll();
		System.out.println("here goes the movies before removing "+ movies);
		movieRepository.deleteByTitle("egh");
		movies = movieRepository.listAll();
		System.out.println("here goes the movies after deleting "+ movies);

	}

	@Test
	void TestfindByTitle() throws IOException {
		MovieRepository movieRepository = new MovieRepository();
		List<Movie> movies = movieRepository.listAll();
		System.out.println("here goes the movies "+ movies);
		List<Movie> foundMovie= movieRepository.findByTitle("cean");
		System.out.println("I find movie "+ foundMovie);

	}
	@Test
	void TestfindByDirector() throws IOException {
		MovieRepository movieRepository = new MovieRepository();
		List<Movie> movies = movieRepository.listAll();
		System.out.println("here goes the movies "+ movies);
		List<Movie> foundMovie= movieRepository.findByDirector("ross");
		System.out.println("I find movie "+ foundMovie);
	}

	//Thriller
	@Test
	void TestfindByType() throws IOException {
		MovieRepository movieRepository = new MovieRepository();
		List<Movie> movies = movieRepository.listAll();
		System.out.println("here goes the movies "+ movies);
		List<Movie> foundMovie= movieRepository.findByType("Thriller");
		System.out.println("I find movie "+ foundMovie);
	}

	@Test
	void TestfindByReleaseDate() throws IOException {
		MovieRepository movieRepository = new MovieRepository();
		List<Movie> movies = movieRepository.listAll();
		System.out.println("here goes the movies "+ movies);
		List<Movie> foundMovie= movieRepository.findByReleaseDate("21/03/2012");
		System.out.println("I find movie "+ foundMovie);
	}

	@Test
	void testingSplit(){
		String releaseDate = "13-06-2018";
		String[] split = releaseDate.split("-");
		System.out.println(split[0]);
		//releaseDate=split[0]+"/"+split[1]+"/"+split[2];
	}

	@Test
	void testUpdatingMovies() throws IOException {
		MovieRepository movieRepository = new MovieRepository();

		Movie movie = new Movie();
		movie.setTitle("egh");
		movie.setDirector("ghaffari");
		movie.setReleaseDate("21/05/1990");
		movie.setType("egh22222");
		movieRepository.updateMovie(movie);

		//releaseDate=split[0]+"/"+split[1]+"/"+split[2];
	}






}
