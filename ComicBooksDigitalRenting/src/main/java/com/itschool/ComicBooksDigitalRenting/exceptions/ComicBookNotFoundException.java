package com.itschool.ComicBooksDigitalRenting.exceptions;

public class ComicBookNotFoundException extends RuntimeException{

    public ComicBookNotFoundException(String message) {
        super(message);
    }
}
