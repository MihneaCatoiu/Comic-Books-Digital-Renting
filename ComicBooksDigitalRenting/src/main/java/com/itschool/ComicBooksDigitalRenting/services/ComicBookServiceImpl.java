package com.itschool.ComicBooksDigitalRenting.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itschool.ComicBooksDigitalRenting.exceptions.ComicBookNotFoundException;
import com.itschool.ComicBooksDigitalRenting.models.dtos.ComicBookDTO;
import com.itschool.ComicBooksDigitalRenting.models.dtos.RequestComicBookDTO;
import com.itschool.ComicBooksDigitalRenting.models.dtos.ResponseComicBookDTO;
import com.itschool.ComicBooksDigitalRenting.models.entities.ComicBook;
import com.itschool.ComicBooksDigitalRenting.repositories.ComicBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ComicBookServiceImpl implements ComicBookService {

    private final ObjectMapper objectMapper;
    private final ComicBookRepository comicBookRepository;

    public ComicBookServiceImpl(ObjectMapper objectMapper, ComicBookRepository comicBookRepository) {
        this.objectMapper = objectMapper;
        this.comicBookRepository = comicBookRepository;
    }

    @Override
    public ComicBook createComicBook(ComicBookDTO comicBookDTO) {
        return null;
    }

    @Override
    public ComicBook getComicBookById(Long id) {
        return null;
    }

    @Override
    public ComicBook updateComicBook(Long id, ComicBookDTO comicBookDTO) {
        return null;
    }

    @Override
    public void deleteComicBook(Long id) {

    }

    @Override
    public ResponseComicBookDTO createComicBook(RequestComicBookDTO requestComicBookDTO) {
        ComicBook comicBookEntity = objectMapper.convertValue(requestComicBookDTO, ComicBook.class);
        ComicBook comicBookEntityResponse = comicBookRepository.save(comicBookEntity);
        log.info("Comic book with id {} was successfully saved!");
        return objectMapper.convertValue(comicBookEntityResponse, ResponseComicBookDTO.class);
    }
    @Override
    public ResponseComicBookDTO updateComicBookCopies(Long comicBookId, int newCopiesAvailable) {
        ComicBook comicBook = comicBookRepository.findById(comicBookId).orElseThrow(() -> new ComicBookNotFoundException("The comic book with the id " + comicBookId + "was not found!"));
        comicBook.setCopiesAvailable(newCopiesAvailable);
        ComicBook updateComicBook = comicBookRepository.save(comicBook);
        log.info("Updated comic books copies for id {}", updateComicBook.getId());
        return objectMapper.convertValue(updateComicBook, ResponseComicBookDTO.class);
    }
    @Override
    public List<ResponseComicBookDTO> getComicBooks(String title, String superhero, String availabilityStatus) {
        Specification<ComicBook> spec = Specification
                .where(ComicBookSpecification.titleContains(title))
                .and(ComicBookSpecification.superheroContains(superhero))
                .and(ComicBookSpecification.availabilityStatusContains(availabilityStatus));

        List<ComicBook> comicBooks = comicBookRepository.findAll((Sort) spec);
        log.info("{} comic books found", comicBooks.size());

        return comicBooks.stream()
                .map(comicBook -> objectMapper.convertValue(comicBook, ResponseComicBookDTO.class))
                .toList();
    }
}

