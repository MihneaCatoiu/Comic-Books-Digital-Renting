package com.itschool.ComicBooksDigitalRenting.controllers;

import com.itschool.ComicBooksDigitalRenting.models.dtos.CopiesAvailableDTO;
import com.itschool.ComicBooksDigitalRenting.models.dtos.RentRecordDTO;
import com.itschool.ComicBooksDigitalRenting.models.dtos.ResponseComicBookDTO;
import com.itschool.ComicBooksDigitalRenting.models.dtos.ResponseRentRecordDTO;
import com.itschool.ComicBooksDigitalRenting.services.RentRecordService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/rent-records")
@RestController
public class RentRecordController {

    private final RentRecordService rentRecordService;

    public RentRecordController(RentRecordService rentRecordService) {
        this.rentRecordService = rentRecordService;
    }

    @PostMapping
    public ResponseEntity<ResponseComicBookDTO> createRentComicBook(@Valid @RequestBody RentRecordDTO rentRecordDTO) {
        rentRecordService.rentComicBook(rentRecordDTO);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ResponseRentRecordDTO> updateRentRecords(@PathVariable Long id, @RequestBody RentRecordDTO rentRecordDTO) {
        return ResponseEntity.ok(rentRecordService.updateRentRecords(id, rentRecordService.getRentRecords()));
    }

    @GetMapping("/customerId")
    public ResponseEntity<List<ResponseRentRecordDTO>> getRentRecords(
            @RequestParam(value = "customerId", required = false) Long customerId,
            @RequestParam(value = "comicBookId", required = false) Long comicBookId){
        return ResponseEntity.ok(rentRecordService.getRentRecords(customerId, comicBookId));
    }

    @Operation(summary = "Delete a record by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecordById(@PathVariable Long id) {
        rentRecordService.deleteRentRecordById(id);
        return ResponseEntity.noContent().build();
    }
}
