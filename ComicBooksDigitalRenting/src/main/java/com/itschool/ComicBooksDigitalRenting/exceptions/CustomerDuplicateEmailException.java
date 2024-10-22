package com.itschool.ComicBooksDigitalRenting.exceptions;

public class CustomerDuplicateEmailException extends RuntimeException {

    public CustomerDuplicateEmailException(String message) {
        super(message);
    }
}
