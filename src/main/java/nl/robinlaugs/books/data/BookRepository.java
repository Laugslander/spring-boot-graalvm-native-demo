package nl.robinlaugs.books.data;

import nl.robinlaugs.books.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
