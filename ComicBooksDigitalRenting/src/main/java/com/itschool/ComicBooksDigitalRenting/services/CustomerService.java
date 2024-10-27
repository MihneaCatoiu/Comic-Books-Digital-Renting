package com.itschool.ComicBooksDigitalRenting.services;

import com.itschool.ComicBooksDigitalRenting.models.dtos.RequestCustomerDTO;
import com.itschool.ComicBooksDigitalRenting.models.dtos.ResponseCustomerDTO;

import java.util.List;

public interface CustomerService {

    ResponseCustomerDTO createCustomer(RequestCustomerDTO requestCustomerDTO);

    ResponseCustomerDTO updateCustomerEmail(Long customerId, String newEmail);

    List<ResponseCustomerDTO> getCustomer(String firstName);

    RequestCustomerDTO updateCustomer(Long id, RequestCustomerDTO requestCustomerDTO);

    void deleteCustomerById(Long id);
}
