package com.itschool.ComicBooksDigitalRenting.integration_tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itschool.ComicBooksDigitalRenting.models.dtos.*;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@AutoConfigureTestDatabase
public class RentRecordControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testCreateRentRecordShouldPass() throws Exception {
        RequestComicBookDTO requestComicBookDTO = new RequestComicBookDTO();
        requestComicBookDTO.setTitle("test title");
        requestComicBookDTO.setSuperhero("test sperhero");
        requestComicBookDTO.setCopiesAvailable(5);

        mockMvc.perform(post("/api/comic-books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestComicBookDTO)))
                .andExpect(status().isOk());

        RequestCustomerDTO requestCustomerDTO = new RequestCustomerDTO();
        requestCustomerDTO.setFirstName("first name");
        requestCustomerDTO.setLastName("last name");
        requestCustomerDTO.setEmail("test@gmial.com");

        mockMvc.perform(post("/api/customers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestCustomerDTO)))
                .andExpect(status().isOk());

        RentRecordDTO rentRecordDTO = new RentRecordDTO();
        rentRecordDTO.setComicBookId(1L);
        rentRecordDTO.setCustomerId(1L);

        mockMvc.perform(post("/api/rent-records")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(rentRecordDTO)))
                .andExpect(status().isNoContent());
    }
}
