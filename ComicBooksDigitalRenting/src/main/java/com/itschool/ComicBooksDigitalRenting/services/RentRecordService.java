package com.itschool.ComicBooksDigitalRenting.services;

import com.itschool.ComicBooksDigitalRenting.models.dtos.RentRecordDTO;

public interface RentRecordService {
    void rentComicBook(RentRecordDTO rentRecordDTO);
}
