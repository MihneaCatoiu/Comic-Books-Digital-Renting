package com.itschool.ComicBooksDigitalRenting.models.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RequestComicBookDTO {

    @NotBlank(message = "This field cannot be empty. Please specify the title")
    private String title;
    @NotBlank(message = "This field cannot be empty. Please specify the main character")
    private String superhero;
    private String authors;
    private String isbn;
    @Min(value = 0, message = "Copies available must be at least 0")
    private int copiesAvailable;
    private String publisher;
    private String publicationDate;
    private String synopsis;
    private String availabilityStatus;
    private String genre;
    private double rentalPrice;

    public @NotBlank(message = "This field cannot be empty. Please specify the title") String getTitle() {
        return title;
    }

    public void setTitle(@NotBlank(message = "This field cannot be empty. Please specify the title") String title) {
        this.title = title;
    }

    public @NotBlank(message = "This field cannot be empty. Please specify the main character") String getSuperhero() {
        return superhero;
    }

    public void setSuperhero(@NotBlank(message = "This field cannot be empty. Please specify the main character") String superhero) {
        this.superhero = superhero;
    }

    @Min(value = 0, message = "Copies available must be at least 0")
    public int getCopiesAvailable() {
        return copiesAvailable;
    }

    public void setCopiesAvailable(@Min(value = 0, message = "Copies available must be at least 0") int copiesAvailable) {
        this.copiesAvailable = copiesAvailable;
    }
}
