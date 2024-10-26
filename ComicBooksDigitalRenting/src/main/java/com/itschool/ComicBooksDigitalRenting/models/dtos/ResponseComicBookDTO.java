package com.itschool.ComicBooksDigitalRenting.models.dtos;

import lombok.Data;
import java.time.LocalDate;

@Data
public class ResponseComicBookDTO {

    private Long id;
    private String title;
    private String authors;
    private String isbn;
    private String superhero;
    private int copiesAvailable;
    private String publisher;
    private String publicationDate;
    private String synopsis;
    private String availabilityStatus;
    private String genre;
    private double rentalPrice;

}
