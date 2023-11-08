package lezione22.runners;

import lezione22.enteties.BlogPost;
import lezione22.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class AddBlogPosts implements CommandLineRunner {
    @Autowired
    private BlogPostService blogPostService;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 200; i++) {
            blogPostService.save(BlogPost.builder().build());
        }
    }
}
