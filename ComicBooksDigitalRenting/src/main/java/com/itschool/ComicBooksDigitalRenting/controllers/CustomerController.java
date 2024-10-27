package com.itschool.ComicBooksDigitalRenting.controllers;

import com.itschool.ComicBooksDigitalRenting.models.dtos.NewEmailDTO;
import com.itschool.ComicBooksDigitalRenting.models.dtos.RequestCustomerDTO;
import com.itschool.ComicBooksDigitalRenting.models.dtos.ResponseCustomerDTO;
import com.itschool.ComicBooksDigitalRenting.services.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/api/customers")
@RestController
public class CustomerController {

    private final CustomerService customerService;
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Operation(summary = "Create a new customer")
    @PostMapping
    public ResponseEntity<ResponseCustomerDTO> createCustomer(@Valid @RequestBody RequestCustomerDTO requestCustomerDTO) {
        return ResponseEntity.ok(customerService.createCustomer(requestCustomerDTO));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ResponseCustomerDTO> updateCustomerEmail(@PathVariable Long id, @RequestBody NewEmailDTO email) {
        return ResponseEntity.ok(customerService.updateCustomerEmail(id, email.getEmail()));
    }

    @Operation(summary = "Get all filtered customers by their first name, last name and email.")
    @GetMapping
    public ResponseEntity<List<ResponseCustomerDTO>> getCustomer(
            @RequestParam(value = "firstName", required = false) String firstName,
            @RequestParam(value = "lastName", required = false) String lastName,
            @RequestParam(value = "email", required = false) String email) {
        return ResponseEntity.ok(customerService.getCustomer(firstName, lastName, email));
    }

    @Operation(summary = "Delete a customer by his/hers id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomerById(@PathVariable Long id) {
        customerService.deleteCustomerById(id);
        return ResponseEntity.noContent().build();
    }
}
