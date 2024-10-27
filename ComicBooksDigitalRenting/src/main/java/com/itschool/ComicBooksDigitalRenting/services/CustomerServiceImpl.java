package com.itschool.ComicBooksDigitalRenting.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itschool.ComicBooksDigitalRenting.exceptions.CustomerDuplicateEmailException;
import com.itschool.ComicBooksDigitalRenting.exceptions.CustomerNotFoundException;
import com.itschool.ComicBooksDigitalRenting.models.dtos.RequestCustomerDTO;
import com.itschool.ComicBooksDigitalRenting.models.dtos.ResponseCustomerDTO;
import com.itschool.ComicBooksDigitalRenting.models.entities.Customer;
import com.itschool.ComicBooksDigitalRenting.repositories.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    private final ObjectMapper objectMapper;
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(ObjectMapper objectMapper, CustomerRepository customerRepository) {
        this.objectMapper = objectMapper;
        this.customerRepository = customerRepository;
    }

    @Override
    public ResponseCustomerDTO createCustomer(RequestCustomerDTO requestCustomerDTO) {
        validateEmailAddress(requestCustomerDTO);
        Customer customerEntity = objectMapper.convertValue(requestCustomerDTO, Customer.class);
        Customer customerEntityResponse = customerRepository.save(customerEntity);
        log.info("Customer with the id {} was successfully saved", customerEntityResponse.getId());
        return objectMapper.convertValue(customerEntityResponse, ResponseCustomerDTO.class);
    }

    @Override
    public void deleteCustomerById(Long id) {
        customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer with id " + id + "was not found"));
        customerRepository.deleteById(id);
        log.info("Customer with id {} was deleted successfully", id);
    }

    @Override
    public ResponseCustomerDTO updateCustomerEmail(Long customerId, String newEmail) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new CustomerNotFoundException("The customer with the id " + customerId + " was not found!"));
        customer.setEmail(newEmail);
        Customer updateCustomerEmail = customerRepository.save(customer);
        log.info("Updated email for id {}", updateCustomerEmail.getId());
        return objectMapper.convertValue(updateCustomerEmail, ResponseCustomerDTO.class);
    }

    @Override
    public List<ResponseCustomerDTO> getCustomer(String firstName) {
        return customerRepository.getCustomer(firstName)
                .stream()
                .map(customer -> objectMapper.convertValue(customer, ResponseCustomerDTO.class))
                .toList();
    }

    @Override
    public RequestCustomerDTO updateCustomer(Long id, RequestCustomerDTO requestCustomerDTO) {
        return null;
    }

    private void validateEmailAddress(RequestCustomerDTO requestCustomerDTO) {
        Customer customer = customerRepository.findByEmail(requestCustomerDTO.getEmail());
        if (customer != null) {
            throw new CustomerDuplicateEmailException("Email address already in use");
        }
    }
}
