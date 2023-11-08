package lezione22.enteties;

import com.github.javafaker.Faker;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
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

    @Override
    public String toString() {
        return "BlogPost{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", cover='" + cover + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", readingTime=" + readingTime +
                ", createdAt=" + createdAt +
                '}';
    }

    public static class BlogPostBuiler {
        private Faker faker = new Faker(Locale.ITALY);
        private String title = faker.book().title();
        private String content = faker.lorem().characters(50);
        private String category = faker.book().genre();
        private int readingTime = new Random().nextInt(10, 240);
    }
}
