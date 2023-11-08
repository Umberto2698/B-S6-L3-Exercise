package lezione22.runners;

import lezione22.enteties.Author;
import lezione22.enteties.BlogPost;
import lezione22.services.AuthorService;
import lezione22.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class AddBlogPosts implements CommandLineRunner {
    @Autowired
    private BlogPostService blogPostService;
    @Autowired
    private AuthorService authorService;

    @Override
    public void run(String... args) throws Exception {
        Page<Author> authors = authorService.getAuthors(0, 50, "id");
        for (int i = 0; i < 200; i++) {
            BlogPost blogPost = BlogPost.builder().build();
            int n = authors.getSize();
            blogPost.setAuthor(authors.toList().get(n));
            blogPostService.save(blogPost);
        }
    }
}
