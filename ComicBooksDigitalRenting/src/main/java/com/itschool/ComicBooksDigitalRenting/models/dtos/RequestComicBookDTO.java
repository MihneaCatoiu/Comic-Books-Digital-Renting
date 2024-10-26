package com.itschool.ComicBooksDigitalRenting.models.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RequestComicBookDTO {

    @NotBlank(message = "This field cannot be empty. Please specify the title.")
    private String title;
    @NotBlank(message = "This field cannot be empty. Please specify the main character.")
    private String superhero;
    @NotBlank(message = "This field cannot be empty. Please specify the author.")
    private String authors;
    @NotBlank(message = "This field cannot be empty. Please specify the isbn.")
    private String isbn;
    @Min(value = 0, message = "Copies available must be at least 0.")
    private int copiesAvailable;
    @NotBlank(message = "This field cannot be empty. Please specify the publisher.")
    private String publisher;
    @NotBlank(message = "This field cannot be empty. Please specify the publication date.")
    private String publicationDate;
    @NotBlank(message = "This field cannot be empty. Please specify the synopsis.")
    private String synopsis;
    @NotBlank(message = "This field cannot be empty. Please specify the availability status.")
    private String availabilityStatus;
    @NotBlank(message = "This field cannot be empty. Please specify the genre.")
    private String genre;
    @Min(value = 0, message = "The renting cost should be at least 0.")
    private double rentalPrice;

}
