package com.example.books;



import com.example.books.controllers.ResController;
import com.example.books.models.Book;
import com.example.books.services.BooksService;
import com.example.books.services.BooksServiceRest;
//import org.junit.Test;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.*;

import javax.net.ssl.SSLEngineResult;
import java.util.ArrayList;
import java.util.Collection;

@ComponentScan()
@WebMvcTest(ResController.class)

public class RestControllerTest {

//@AutoConfigureMockMvc
@Autowired
private MockMvc mockMvc;

@MockBean
private BooksServiceRest booksService;

@Test
public void shouldSendRequest() throws Exception {
    mockMvc.perform(
            MockMvcRequestBuilders.post("/add-books")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(RestControllerTest.class.getResourceAsStream("/request.json").readAllBytes())
        ) .andExpect(MockMvcResultMatchers.status().isOk());
          //.andExpect(MockMvcResultMatchers.content().string(new String(RestControllerTest.class.getResourceAsStream("/request.json").readAllBytes())))
    }

@Test
public void testBookByName() throws Exception{

    Collection<Book> response = new ArrayList<>();
    response.add( Book.of("aaa","aaa", "aaa"));
    when(booksService.getBooks(any()))
            .thenReturn(response);



    mockMvc.perform(MockMvcRequestBuilders.get("/books/name")
    ).andExpect(MockMvcResultMatchers.content().json(new String
            (RestControllerTest.class.getResourceAsStream("/response.json").readAllBytes()),false));

}

}

