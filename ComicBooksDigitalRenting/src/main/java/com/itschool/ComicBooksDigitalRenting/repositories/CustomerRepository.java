package com.itschool.ComicBooksDigitalRenting.repositories;

import com.itschool.ComicBooksDigitalRenting.models.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByEmail(String email);

    @Query("SELECT c FROM Customer c WHERE c.firstName = :firstName")
    List<Customer> getCustomer(@Param("firstName") String firstName);
}
