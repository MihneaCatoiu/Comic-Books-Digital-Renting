package com.itschool.ComicBooksDigitalRenting.repositories;

import com.itschool.ComicBooksDigitalRenting.models.entities.Customer;
import com.itschool.ComicBooksDigitalRenting.models.entities.RentRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentRecordRepository extends JpaRepository<RentRecord, Long> {

    @Query("SELECT c FROM RentRecord c WHERE c.customerId = :customerId")
    List<RentRecord> getRentRecords(@Param("customerId") Customer customerId);
}
