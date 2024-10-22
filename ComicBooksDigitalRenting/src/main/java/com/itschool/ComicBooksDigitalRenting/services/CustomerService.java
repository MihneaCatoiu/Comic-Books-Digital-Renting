package com.itschool.ComicBooksDigitalRenting.services;

import com.itschool.ComicBooksDigitalRenting.models.dtos.RequestCustomerDTO;
import com.itschool.ComicBooksDigitalRenting.models.dtos.ResponseCustomerDTO;

public interface CustomerService {

    ResponseCustomerDTO createCustomer(RequestCustomerDTO requestCustomerDTO);
    void deleteCustomerById(Long id);
}
