package nl.robinlaugs.books.controller;

import lombok.RequiredArgsConstructor;
import nl.robinlaugs.books.data.BookRepository;
import nl.robinlaugs.books.model.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
class BookController {

    private final BookRepository repository;

    @GetMapping("/books")
    Collection<Book> getBooks() {
        return this.repository.findAll();
    }

}