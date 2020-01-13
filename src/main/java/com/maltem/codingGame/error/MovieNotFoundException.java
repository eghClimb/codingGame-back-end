package com.maltem.codingGame.error;

public class MovieNotFoundException extends RuntimeException {
    public MovieNotFoundException(String title) {
        super("Book id not found : " + title);
    }
}
