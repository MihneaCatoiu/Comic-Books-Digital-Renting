package com.itschool.ComicBooksDigitalRenting.models.dtos;

import lombok.Data;

@Data
public class ResponseRentRecordDTO {
    private Long customerId;
    private Long comicBookId;
}
