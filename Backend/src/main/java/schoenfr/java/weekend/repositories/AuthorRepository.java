package schoenfr.java.weekend.repositories;

import org.springframework.data.repository.CrudRepository;
import schoenfr.java.weekend.entities.Author;

import java.util.List;

public interface AuthorRepository extends CrudRepository<Author, Long> {

    List<Author> findByName(String name);

}
