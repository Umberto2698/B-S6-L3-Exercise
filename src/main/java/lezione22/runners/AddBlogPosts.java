package lezione22.runners;

import lezione22.answer_entities.BlogPostResponse;
import lezione22.enteties.Author;
import lezione22.services.AuthorService;
import lezione22.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@Component
@Order(2)
public class AddBlogPosts implements CommandLineRunner {
    @Autowired
    private BlogPostService blogPostService;
    @Autowired
    private AuthorService authorService;

    @Override
    public void run(String... args) throws Exception {
        List<Author> authors = authorService.getAuthors(0, 50, "id").toList();
        for (int i = 0; i < 200; i++) {
            int n = new Random().nextInt(0, authors.size());
            UUID rnd = authors.get(n).getId();
            BlogPostResponse blogPost = BlogPostResponse.builder().authorId(rnd).build();
            blogPostService.save(blogPost);
        }
    }
}
