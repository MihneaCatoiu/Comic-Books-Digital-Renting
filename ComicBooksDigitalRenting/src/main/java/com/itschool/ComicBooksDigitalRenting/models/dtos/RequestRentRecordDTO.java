package com.itschool.ComicBooksDigitalRenting.models.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RequestRentRecordDTO {

    @NotBlank(message = "This field cannot be empty.")
    private Long customerId;
    @NotBlank(message = "This field cannot be empty.")
    private Long comicBookId;
}
