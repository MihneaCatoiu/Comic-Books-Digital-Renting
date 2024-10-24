package com.itschool.ComicBooksDigitalRenting.services;

import com.itschool.ComicBooksDigitalRenting.models.dtos.RentRecordDTO;
import com.itschool.ComicBooksDigitalRenting.models.dtos.ResponseComicBookDTO;
import com.itschool.ComicBooksDigitalRenting.models.dtos.ResponseRentRecordDTO;

import java.util.List;

public interface RentRecordService {
    void rentComicBook(RentRecordDTO rentRecordDTO);

    void deleteRentRecordById(Long id);

    List<ResponseRentRecordDTO> getRentRecords(Long customerId, Long comicBookId);

    Object getRentRecords();

    ResponseRentRecordDTO updateRentRecords(Long id, Object rentRecords);
}
