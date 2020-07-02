package nl.robinlaugs.books.data;

import lombok.RequiredArgsConstructor;
import nl.robinlaugs.books.model.Book;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class BookInitializer implements ApplicationListener<ApplicationReadyEvent> {

    private final BookRepository repository;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        Stream.of(
                "Java OCP 11 Programmer I Study Guide",
                "Java OCP 11 Programmer II Study Guide",
                "AWS Certified Solutions Architect Study Guide"
        )
                .map(Book::new)
                .map(repository::save)
                .forEach(System.out::println);
    }
}
