package com.itschool.ComicBooksDigitalRenting.integration_tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itschool.ComicBooksDigitalRenting.models.dtos.RequestComicBookDTO;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@AutoConfigureTestDatabase
public class ComicBookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testCreateComicBookShouldPass() throws Exception {
        RequestComicBookDTO requestComicBookDTO = new RequestComicBookDTO();
        requestComicBookDTO.setTitle("title");
        requestComicBookDTO.setSuperhero("superhero");
        requestComicBookDTO.setCopiesAvailable(10);

        mockMvc.perform(post("/api/comicbooks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestComicBookDTO)))
                .andExpect(status().isOk());
    }
}

