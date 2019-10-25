package schoenfr.java.weekend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import schoenfr.java.weekend.entities.Book;
import schoenfr.java.weekend.repositories.BookRepository;
import schoenfr.java.weekend.service.dto.BookDto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public Iterable<BookDto> getAllBooks() {
        List<BookDto> books = new ArrayList<>();
        for (Book book : bookRepository.findAll()) {
            books.add(new BookDto(book.getName(),
                    book.getYear(),
                    book.getAuthor().getName(),
                    book.getCoverImageUrl()));
        }
        return books;
    }

    @GetMapping("/key")
    public String getBookKey(String bookName) {
        Book book = bookRepository.findByName(bookName);
        if (book != null) {
            String firstLetters = Arrays.stream(book.getName().split(" "))
                    .map(word -> word.substring(0, 1))
                    .reduce((a, b) -> a + b).get();
            String lastNamePart = book.getAuthor().getName().substring(0, 3).toUpperCase();
            String year = String.valueOf(book.getYear() % 100);
            return firstLetters + lastNamePart + year;
        } else {
            return "not found";
        }
    }

}
