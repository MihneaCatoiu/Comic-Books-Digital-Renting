package com.itschool.ComicBooksDigitalRenting.services;

import com.itschool.ComicBooksDigitalRenting.models.entities.ComicBook;
import org.springframework.data.jpa.domain.Specification;

public class ComicBookSpecification {

    public static Specification<ComicBook> titleContains(String title) {
        return (comicBook, query, criteriaBuilder) -> title ==null ? null :
                criteriaBuilder.like(criteriaBuilder.lower(comicBook.get("title")), "%" + title.toLowerCase() + "%");
    }
    public static Specification<ComicBook> superheroContains(String superhero) {
        return (comicBook, query, criteriaBuilder) -> superhero == null ? null :
                criteriaBuilder.like(criteriaBuilder.lower(comicBook.get("superhero")), "%" + superhero.toLowerCase() + "%");
    }
    public static Specification<ComicBook> availabilityStatusContains(String availabilityStatus) {
        return (comicBook, query, criteriaBuilder) -> availabilityStatus == null ? null :
                criteriaBuilder.like(criteriaBuilder.lower(comicBook.get("availability_status")), "%" + availabilityStatus.toLowerCase() + "%");
    }
}
