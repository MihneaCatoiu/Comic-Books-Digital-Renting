package com.itschool.ComicBooksDigitalRenting.repositories;

import com.itschool.ComicBooksDigitalRenting.models.entities.ComicBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ComicBookRepository extends JpaRepository<ComicBook, Long> {

    @Query("SELECT c FROM ComicBook c WHERE (:title IS NULL OR c.title = :title) " +
            "AND (:superhero IS NULL OR c.superhero = :superhero) " +
            "AND (:availabilityStatus IS NULL OR c.availabilityStatus = :availabilityStatus)")
    List<ComicBook> findComicBooksByFilter(@Param("title") String title,
                                           @Param("superhero") String superhero,
                                           @Param("availabilityStatus") String availabilityStatus);
}
