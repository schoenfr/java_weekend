package schoenfr.java.weekend.repositories;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

import schoenfr.java.weekend.entities.Author;
import schoenfr.java.weekend.entities.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

    Book findByName(String name);

    List<Book> findByAuthor(Author author);

}
