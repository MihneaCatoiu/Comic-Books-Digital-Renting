package com.itschool.ComicBooksDigitalRenting.services;

import com.itschool.ComicBooksDigitalRenting.models.entities.Customer;
import org.springframework.data.jpa.domain.Specification;

public class CustomerSpecification {

    public static Specification<Customer> firstNameContains(String firstName) {
        return (customer, query, criteriaBuilder) -> firstName == null ? null :
                criteriaBuilder.like(criteriaBuilder.lower(customer.get("firstName")), "%" + firstName.toLowerCase() + "%");
    }
    public static Specification<Customer> lastNameContains(String lastName) {
        return (customer, query, criteriaBuilder) -> lastName == null ? null :
                criteriaBuilder.like(criteriaBuilder.lower(customer.get("lastName")), "%" + lastName.toLowerCase() + "%");
    }
    public static Specification<Customer> emailContains(String email) {
        return (customer, query, criteriaBuilder) -> email == null ? null :
                criteriaBuilder.like(criteriaBuilder.lower(customer.get("email")), "%" + email.toLowerCase() + "%");
    }
}
