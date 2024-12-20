package com.itschool.ComicBooksDigitalRenting.models.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "customers")
public class Customer {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(name = "first_name")
        private String firstName;
        @Column(name = "last_name")
        private String lastName;
        @Column(name = "email", unique = true)
        private String email;
        @OneToMany(mappedBy = "customerId",cascade = CascadeType.ALL)
        @JsonManagedReference
        private List<RentRecord> rentRecords;
}
