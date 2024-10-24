package com.itschool.ComicBooksDigitalRenting.services;

import com.itschool.ComicBooksDigitalRenting.exceptions.ComicBookNotFoundException;
import com.itschool.ComicBooksDigitalRenting.exceptions.CustomerNotFoundException;
import com.itschool.ComicBooksDigitalRenting.models.dtos.RentRecordDTO;
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

    private final ComicBookRepository comicBookRepository;
    private final CustomerRepository customerRepository;
    private final RentRecordRepository rentRecordRepository;

    public RentRecordServiceImpl(ComicBookRepository comicBookRepository, CustomerRepository customerRepository, RentRecordRepository rentRecordRepository) {
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
        rentRecord.setCustomer(customer);
        rentRecord.setRentedAt(LocalDateTime.now());

        comicBook.setCopiesAvailable(comicBook.getCopiesAvailable() - 1);
        comicBookRepository.save(comicBook);
        log.info("Copies available just updated");

        rentRecordRepository.save(rentRecord);
        log.info("Rent record updated");
    }

    public void deleteRentRecordById(Long id) {

    }

    public List<ResponseRentRecordDTO> getRentRecords(Long customerId, Long comicBookId) {
        return List.of();
    }

    public Object getRentRecords() {
        return null;
    }

    public ResponseRentRecordDTO updateRentRecords(Long id, Object rentRecords) {
        return null;
    }
}