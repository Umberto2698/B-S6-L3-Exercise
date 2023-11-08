package lezione22.answer_entities;

import com.github.javafaker.Faker;
import lombok.*;

import java.util.Locale;
import java.util.Random;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderClassName = "BlogPostResponseBuilder")
public class BlogPostResponse {
    private String title;
    private String content;
    private String category;
    private int readingTime;
    private UUID authorId;

    public static class BlogPostResponseBuilder {
        private Faker faker = new Faker(Locale.ITALY);
        private String title = faker.book().title();
        private String content = faker.lorem().characters(50);
        private String category = faker.book().genre();
        private int readingTime = new Random().nextInt(10, 240);
        private UUID author_id = authorId;
    }
}
