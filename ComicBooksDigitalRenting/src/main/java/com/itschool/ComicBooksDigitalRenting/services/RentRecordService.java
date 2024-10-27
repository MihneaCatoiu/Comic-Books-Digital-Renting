package com.itschool.ComicBooksDigitalRenting.services;

import com.itschool.ComicBooksDigitalRenting.models.dtos.RentRecordDTO;
import com.itschool.ComicBooksDigitalRenting.models.dtos.ResponseRentRecordDTO;
import com.itschool.ComicBooksDigitalRenting.models.entities.Customer;

import java.util.List;

public interface RentRecordService {

    void rentComicBook(RentRecordDTO rentRecordDTO);

    List<ResponseRentRecordDTO> getRentRecords(Customer customerId);

    ResponseRentRecordDTO updateRentRecords(Long rentUpdate, String returnDate);

    void deleteRentRecordById(Long id);

}
