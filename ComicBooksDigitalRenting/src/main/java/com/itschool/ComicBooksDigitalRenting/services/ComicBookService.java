package com.itschool.ComicBooksDigitalRenting.services;

import com.itschool.ComicBooksDigitalRenting.models.dtos.RequestComicBookDTO;
import com.itschool.ComicBooksDigitalRenting.models.dtos.ResponseComicBookDTO;

import java.util.List;

public interface ComicBookService {

    ResponseComicBookDTO createComicBook(RequestComicBookDTO requestComicBookDTO);

    List<ResponseComicBookDTO> getComicBooksByTitle(String title);

    ResponseComicBookDTO updateComicBookCopies(Long comicBookId, int newCopiesAvailable);

    void deleteComicBookById(Long id);

}
