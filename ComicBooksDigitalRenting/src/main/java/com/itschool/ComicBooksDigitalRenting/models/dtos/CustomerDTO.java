package com.itschool.ComicBooksDigitalRenting.models.dtos;

import lombok.Data;

@Data
public class CustomerDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

}
