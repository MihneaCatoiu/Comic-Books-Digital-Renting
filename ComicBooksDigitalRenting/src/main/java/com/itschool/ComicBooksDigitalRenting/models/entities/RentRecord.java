package com.itschool.ComicBooksDigitalRenting.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "rent_records")
public class RentRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "rented_at")
    private LocalDateTime rentedAt;
    @Column(name = "returned_at")
    private LocalDateTime returnedAt;
    @ManyToOne
    @JoinColumn(name = "comic_book_id", nullable = false)
    private ComicBook comicBook;
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
}
