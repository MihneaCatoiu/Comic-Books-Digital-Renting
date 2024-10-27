package com.itschool.ComicBooksDigitalRenting.models.dtos;

import com.itschool.ComicBooksDigitalRenting.models.entities.ComicBook;
import com.itschool.ComicBooksDigitalRenting.models.entities.Customer;
import lombok.Data;

@Data
public class ResponseRentRecordDTO {

    private Long id;
    private Customer customerId;
    private ComicBook comicBookId;
    private String returnDate;

}
