package com.itschool.ComicBooksDigitalRenting.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itschool.ComicBooksDigitalRenting.exceptions.ComicBookNotFoundException;
import com.itschool.ComicBooksDigitalRenting.exceptions.CustomerNotFoundException;
import com.itschool.ComicBooksDigitalRenting.models.dtos.RentRecordDTO;
import com.itschool.ComicBooksDigitalRenting.models.dtos.ResponseComicBookDTO;
import com.itschool.ComicBooksDigitalRenting.models.dtos.ResponseRentRecordDTO;
import com.itschool.ComicBooksDigitalRenting.models.entities.ComicBook;
import com.itschool.ComicBooksDigitalRenting.models.entities.Customer;
import com.itschool.ComicBooksDigitalRenting.models.entities.RentRecord;
import com.itschool.ComicBooksDigitalRenting.repositories.ComicBookRepository;
import com.itschool.ComicBooksDigitalRenting.repositories.CustomerRepository;
import com.itschool.ComicBooksDigitalRenting.repositories.RentRecordRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class RentRecordServiceImpl implements RentRecordService {

    private final ObjectMapper objectMapper;
    private final ComicBookRepository comicBookRepository;
    private final CustomerRepository customerRepository;
    private final RentRecordRepository rentRecordRepository;

    public RentRecordServiceImpl(ObjectMapper objectMapper, ComicBookRepository comicBookRepository, CustomerRepository customerRepository, RentRecordRepository rentRecordRepository) {

        this.objectMapper = objectMapper;
        this.comicBookRepository = comicBookRepository;
        this.customerRepository = customerRepository;
        this.rentRecordRepository = rentRecordRepository;
    }

    @Transactional
    @Override
    public void rentComicBook(RentRecordDTO rentRecordDTO) {
        ComicBook comicBook = comicBookRepository.findById(rentRecordDTO.getComicBookId())
                .orElseThrow(() -> new ComicBookNotFoundException("Sorry, comic book not found"));
        if (comicBook.getCopiesAvailable() <= 0) {
            throw new IllegalArgumentException("Not enough comic books");
        }

        Customer customer = customerRepository.findById(rentRecordDTO.getCustomerId())
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found!"));

        RentRecord rentRecord = new RentRecord();
        rentRecord.setComicBook(comicBook);
        rentRecord.setCustomerId(customer);
        rentRecord.setRentedAt(LocalDateTime.now());

        comicBook.setCopiesAvailable(comicBook.getCopiesAvailable() - 1);
        comicBookRepository.save(comicBook);
        log.info("Copies available just updated");

        rentRecordRepository.save(rentRecord);
        log.info("Rent record updated");
    }

    @Override
    public ResponseRentRecordDTO updateRentRecords(Long rentRecordId, String returnDate) {
        RentRecord rentRecord = rentRecordRepository.findById(rentRecordId).orElseThrow(() -> new ComicBookNotFoundException("The comic book with the id " + rentRecordId + " was not found!"));
        rentRecord.setReturnDate(returnDate);
        RentRecord updateRentRecords = rentRecordRepository.save(rentRecord);
        log.info("Updated rentals for id {}", updateRentRecords.getId());
        return objectMapper.convertValue(updateRentRecords, ResponseRentRecordDTO.class);
    }

    @Override
    public void deleteRentRecordById(Long id) {
        rentRecordRepository.deleteById(id);
    }

    @Override
    public List<ResponseRentRecordDTO> getRentRecords(Customer customerId) {
        return rentRecordRepository.getRentRecords(customerId)
                .stream()
                .map(rentRecord -> objectMapper.convertValue(rentRecord, ResponseRentRecordDTO.class))
                .toList();
    }
}