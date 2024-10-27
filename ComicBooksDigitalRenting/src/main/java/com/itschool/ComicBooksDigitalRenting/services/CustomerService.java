package com.itschool.ComicBooksDigitalRenting.services;

import com.itschool.ComicBooksDigitalRenting.models.dtos.RequestCustomerDTO;
import com.itschool.ComicBooksDigitalRenting.models.dtos.ResponseCustomerDTO;
import java.util.List;

public interface CustomerService {

    ResponseCustomerDTO createCustomer(RequestCustomerDTO requestCustomerDTO);

    List<ResponseCustomerDTO> getCustomer(String firstName, String lastName, String email);

    ResponseCustomerDTO updateCustomerEmail(Long customerId, String newEmail);

    void deleteCustomerById(Long id);
}
