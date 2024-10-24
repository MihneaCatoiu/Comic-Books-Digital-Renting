package com.itschool.ComicBooksDigitalRenting.services;

import com.itschool.ComicBooksDigitalRenting.models.dtos.ComicBookDTO;
import com.itschool.ComicBooksDigitalRenting.models.dtos.RequestComicBookDTO;
import com.itschool.ComicBooksDigitalRenting.models.dtos.ResponseComicBookDTO;
import com.itschool.ComicBooksDigitalRenting.models.entities.ComicBook;

import java.util.List;

public interface ComicBookService {
    ComicBook createComicBook(ComicBookDTO comicBookDTO);
    ComicBook getComicBookById(Long id);
    ComicBook updateComicBook(Long id, ComicBookDTO comicBookDTO);
    void deleteComicBook(Long id);

    ResponseComicBookDTO createComicBook(RequestComicBookDTO requestComicBookDTO);

    ResponseComicBookDTO updateComicBookCopies(Long comicBookId, int newCopiesAvailable);

    List<ResponseComicBookDTO> getComicBooks(String title, String author, String genre);

    void deleteComicBookById(Long id);

    void findComicBookById(long l);
}
