package com.itschool.ComicBooksDigitalRenting.controllers;

import com.itschool.ComicBooksDigitalRenting.models.dtos.RentRecordDTO;
import com.itschool.ComicBooksDigitalRenting.models.dtos.ResponseComicBookDTO;
import com.itschool.ComicBooksDigitalRenting.services.RentRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RentRecordController {

    private final RentRecordService rentRecordService;

    public RentRecordController(RentRecordService rentRecordService) {
        this.rentRecordService = rentRecordService;
    }

    @PostMapping("/api/renting")
    public ResponseEntity<ResponseComicBookDTO> rentComicBook(@RequestBody RentRecordDTO rentRecordDTO) {
        rentRecordService.rentComicBook(rentRecordDTO);
        return ResponseEntity.noContent().build();
    }
}
