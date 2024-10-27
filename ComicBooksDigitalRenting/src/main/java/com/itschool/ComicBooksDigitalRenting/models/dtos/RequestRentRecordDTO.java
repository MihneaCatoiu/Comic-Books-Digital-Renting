package com.itschool.ComicBooksDigitalRenting.models.dtos;

import com.itschool.ComicBooksDigitalRenting.models.entities.Customer;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RequestRentRecordDTO {

    @NotBlank(message = "This field cannot be empty.")
    private Customer customerId;
    @NotBlank(message = "This field cannot be empty.")
    private Long comicBookId;
}
