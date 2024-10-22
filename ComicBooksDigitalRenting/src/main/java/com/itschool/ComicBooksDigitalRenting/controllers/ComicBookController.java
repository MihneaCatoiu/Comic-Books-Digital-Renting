package com.itschool.ComicBooksDigitalRenting.controllers;

import com.itschool.ComicBooksDigitalRenting.models.dtos.CopiesAvailableDTO;
import com.itschool.ComicBooksDigitalRenting.models.dtos.RequestComicBookDTO;
import com.itschool.ComicBooksDigitalRenting.models.dtos.ResponseComicBookDTO;
import com.itschool.ComicBooksDigitalRenting.services.ComicBookService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RequestMapping("/api/comicbooks")
@RestController
public class ComicBookController {

    private final ComicBookService comicBookService;


    public ComicBookController(ComicBookService comicBookService) {
        this.comicBookService = comicBookService;
    }

    @PostMapping
    public ResponseEntity<ResponseComicBookDTO> createComicBook(@Valid @RequestBody RequestComicBookDTO requestComicBookDTO) {
        return ResponseEntity.ok(comicBookService.createComicBook(requestComicBookDTO));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ResponseComicBookDTO> updateComicBookCopies(@PathVariable Long id, @RequestBody CopiesAvailableDTO copiesAvailable) {
        return ResponseEntity.ok(comicBookService.updateComicBookCopies(id, copiesAvailable.getCopiesAvailable()));
    }

    @Operation(summary = "Get all filtered comic books by title, superhero and availability status")
    @GetMapping
    public ResponseEntity<List<ResponseComicBookDTO>> getComicBooks(
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "superhero", required = false) String superhero,
            @RequestParam(value = "availability status", required = false) String availabilityStatus) {
        return ResponseEntity.ok(comicBookService.getComicBooks(title, superhero, availabilityStatus));
    }
    @Operation(summary = "Delete a comic book by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComicBookById(@PathVariable Long id) {
        comicBookService.deleteComicBookById(id);
        return ResponseEntity.noContent().build();
    }
}
