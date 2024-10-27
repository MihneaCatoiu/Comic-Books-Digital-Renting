package com.itschool.ComicBooksDigitalRenting.models.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @ManyToOne
    @JoinColumn(name = "comic_book_id", nullable = false)
    private ComicBook comicBookId;
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    @JsonBackReference
    private Customer customerId;
    @Column(name = "rented_at")
    private LocalDateTime rentedAt;
    @Column(name = "returned_at")
    private String returnDate;
}
