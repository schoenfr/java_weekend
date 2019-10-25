package schoenfr.java.weekend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import schoenfr.java.weekend.entities.Author;
import schoenfr.java.weekend.entities.Book;
import schoenfr.java.weekend.repositories.AuthorRepository;
import schoenfr.java.weekend.repositories.BookRepository;

@SpringBootApplication
public class LibraryApp extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(LibraryApp.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:3000");
            }
        };
    }

    @Bean
    public CommandLineRunner demo(AuthorRepository authorRepository, BookRepository bookRepository) {
        return (args) -> {
            Author simone = authorRepository.save(new Author("Simone de Beauvoir"));
            Author jingfang = authorRepository.save(new Author("Hao Jingfang"));
            Book dasAndereGeschlecht = new Book("Das andere Geschlecht", simone, 1949);
            Book wanderndeHimmel = new Book("Wandernde Himmel", jingfang, 2018);
            dasAndereGeschlecht.setCoverImageUrl("/img/das_andere_geschlecht.jpg");
            wanderndeHimmel.setCoverImageUrl("/img/wandernde_himmel.jpg");
            bookRepository.save(dasAndereGeschlecht);
            bookRepository.save(wanderndeHimmel);

            for (Book book : bookRepository.findAll()) {
                System.out.println(book.getName() + " (" + book.getAuthor().getName() + ", " + book.getYear() + ")");
            }
        };
    }
}
