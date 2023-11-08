package lezione22.enteties;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.javafaker.Faker;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Entity
@Table(name = "authors")
@Builder(builderClassName = "AuthorBuilder")
public class Author {
    @OneToMany(mappedBy = "author")
    @JsonIgnore
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

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                ", avatar='" + avatar + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

    public static class AuthorBuilder {
        private Faker faker = new Faker(Locale.ITALY);
        private String name = faker.name().firstName();
        private String surname = faker.name().lastName();
        private String email = name + "." + surname + "@faker.com";
        private LocalDate birthday = faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
