package nl.robinlaugs.books;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration;

@SpringBootApplication(exclude = SpringDataWebAutoConfiguration.class, proxyBeanMethods = false)
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

}

