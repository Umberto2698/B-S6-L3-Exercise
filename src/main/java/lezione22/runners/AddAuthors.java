package lezione22.runners;

import lezione22.enteties.Author;
import lezione22.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;

//@Component
@Order(1)
public class AddAuthors implements CommandLineRunner {
    @Autowired
    private AuthorService authorService;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 50; i++) {
            authorService.save(Author.builder().build());
        }
    }
}
