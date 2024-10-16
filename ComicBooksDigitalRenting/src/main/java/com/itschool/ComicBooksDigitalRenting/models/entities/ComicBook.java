package com.itschool.ComicBooksDigitalRenting.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "comic_books")
public class ComicBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "authors")
    private String authors;
    @Column(name = "isbn")
    private String isbn;
    @Column(name = "illustrators")
    private String illustrators;
    @Column(name = "copies_available")
    private Integer copiesAvailable;
    @Column(name = "publisher")
    private String publisher;
    @Column(name = "publication_date")
    private LocalDate publicationDate;
    @Column(name = "synopsis")
    private String synopsis;
    @Column(name = "availability_status")
    private Enum availabilityStatus;
    @Column(name = "genre")
    private Enum genre;
    @Column(name = "rental_price")
    private int rentalPrice;

}
