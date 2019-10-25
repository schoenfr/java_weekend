package schoenfr.java.weekend.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import schoenfr.java.weekend.entities.Author;
import schoenfr.java.weekend.entities.Book;
import schoenfr.java.weekend.repositories.BookRepository;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceTest {

    @MockBean
    private BookRepository bookRepository;

    @Autowired
    private BookService bookService;

    @Before
    public void prepare() {
        Book book = new Book();
        book.setName("Why I'm no longer talking to white people about race");
        book.setYear(2017);
        book.setAuthor(new Author("Reni Eddo-Lodge"));
        when(bookRepository.findByName(Mockito.any())).thenReturn(book);
    }

    @Test
    public void testBookKey() {
        String bookKey = bookService.getBookKey("Why I'm no longer talking to white people about race");
        assertEquals("WInlttwparREN17", bookKey);
    }
}
