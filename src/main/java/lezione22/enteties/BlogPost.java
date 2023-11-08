package lezione22.enteties;

import com.github.javafaker.Faker;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;

@Getter
@ToString
@Setter
@Entity
@Table(name = "blog_posts")
@Builder(builderClassName = "BlogPostBuiler")
public class BlogPost {
    @Id
    private UUID id;
    private String category;
    @Column(name = "cover_img")
    private String cover;
    private String title;
    private String content;
    @Column(name = "reading_time")
    private int readingTime;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    public static class BlogPostBuiler {
        private Faker faker = new Faker(Locale.ITALY);
        private UUID id = UUID.randomUUID();
        private String title = faker.book().title();
        private String content = faker.lorem().characters(50);
        private String category = faker.book().genre();
        private String cover = "https://picsum.photos/200/300";
        private int readingTime = new Random().nextInt(10, 240);
    }
}
