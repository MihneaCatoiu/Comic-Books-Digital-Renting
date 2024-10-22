package com.itschool.ComicBooksDigitalRenting.models.dtos;

import lombok.Data;

@Data
public class RentRecordDTO {

    private Long customerId;
    private Long comicBookId;
}
