package com.itschool.ComicBooksDigitalRenting.repositories;

import com.itschool.ComicBooksDigitalRenting.models.entities.RentRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentRecordRepository extends JpaRepository<RentRecord, Long> {
}
