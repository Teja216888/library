package com.library.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.library.entity.Book;
import com.library.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Transactional;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Transactional
@AutoConfigureMockMvc
public class Library {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    MockMvc mockMvc;

    @Test
    void givenBook_whenAddBook_thenReturnBook() throws Exception {
        Book book=new Book(1,"BOOKSTORY");
        String bookJson=new ObjectMapper().writeValueAsString(book);
        //MvcResult result=

                mockMvc.perform(post("/addbook").contentType(MediaType.APPLICATION_JSON).content(bookJson))
                //.andReturn();
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists())
                .andExpect(jsonPath("$").value("book added successfully"));
        //System.out.println("result: "+result.getResponse().getContentAsString());

    }

}
