package com.itschool.ComicBooksDigitalRenting.unit_tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itschool.ComicBooksDigitalRenting.models.dtos.RequestComicBookDTO;
import com.itschool.ComicBooksDigitalRenting.models.dtos.ResponseComicBookDTO;
import com.itschool.ComicBooksDigitalRenting.models.entities.ComicBook;
import com.itschool.ComicBooksDigitalRenting.repositories.ComicBookRepository;
import com.itschool.ComicBooksDigitalRenting.services.ComicBookServiceImpl;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ComicBookServiceTest {

    @Mock
    private ObjectMapper objectMapper;
    @Mock
    private ComicBookRepository comicBookRepository;
    @InjectMocks
    private ComicBookServiceImpl comicBookService;
    @AfterAll
    public static void test() {
    }

    @Test
    void testCreateComicBook() {
        RequestComicBookDTO requestComicBookDTO = new RequestComicBookDTO();
        requestComicBookDTO.setTitle("Test Title");
        requestComicBookDTO.setSuperhero("Test Superhero");
        requestComicBookDTO.setCopiesAvailable(10);

        ResponseComicBookDTO responseComicBookDTO = new ResponseComicBookDTO();
        responseComicBookDTO.setId(1L);
        responseComicBookDTO.setTitle("Test Title");
        responseComicBookDTO.setSuperhero("Test Superhero");
        responseComicBookDTO.setCopiesAvailable(10);

        ComicBook comicBookEntity = new ComicBook();
        comicBookEntity.setId(1L);
        comicBookEntity.setTitle("Test Title");
        comicBookEntity.setSuperhero("Test Superhero");
        comicBookEntity.setCopiesAvailable(10);

        ComicBook savedComicBookEntity = new ComicBook();
        savedComicBookEntity.setId(1L);
        savedComicBookEntity.setTitle("Test Title");
        savedComicBookEntity.setSuperhero("Test Superhero");
        savedComicBookEntity.setCopiesAvailable(10);

        when(objectMapper.convertValue(requestComicBookDTO, ComicBook.class)).thenReturn(comicBookEntity);
        when(comicBookRepository.save(comicBookEntity)).thenReturn(comicBookEntity);
        when(objectMapper.convertValue(savedComicBookEntity, ResponseComicBookDTO.class)).thenReturn(responseComicBookDTO);

        //when
        ResponseComicBookDTO savedBookDTO = comicBookService.createComicBook(requestComicBookDTO);

        //then
        verify(comicBookRepository, times(1)).save(comicBookEntity);
        assertEquals(requestComicBookDTO.getTitle(), savedBookDTO.getTitle());
        assertEquals(requestComicBookDTO.getSuperhero(), savedBookDTO.getSuperhero());
    }
}
