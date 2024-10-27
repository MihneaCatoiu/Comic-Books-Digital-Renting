package com.itschool.ComicBooksDigitalRenting.models.dtos;

import com.itschool.ComicBooksDigitalRenting.models.entities.ComicBook;
import com.itschool.ComicBooksDigitalRenting.models.entities.Customer;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ResponseRentRecordDTO {

    private Long id;
    private Customer customerId;
    private ComicBook comicBook;
    private LocalDateTime rentedAt;
    private String returnDate;
}
