package lezione22.enteties;

import com.github.javafaker.Faker;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

@Getter
@ToString
@Setter
@Entity
@Table(name = "authors")
@Builder(builderClassName = "AuthorBuilder")
public class Author {
    @OneToMany(mappedBy = "author")
    List<BlogPost> blogPostList;

    @Id
    private UUID id;
    private String name;
    private String surname;
    private String email;
    private LocalDate birthday;
    @Column(name = "author_img")
    private String avatar;
    
    @CreationTimestamp
    private LocalDateTime createdAt;

    public static class AuthorBuilder {
        private Faker faker = new Faker(Locale.ITALY);
        private UUID id = UUID.randomUUID();
        private String name = faker.name().firstName();
        private String surname = faker.name().lastName();
        private String email = name + "." + surname + "@faker.com";
        private String avatar = "https://ui-avatars.com/api/?name=" + name + "+" + surname;
        private LocalDate birthday = faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
