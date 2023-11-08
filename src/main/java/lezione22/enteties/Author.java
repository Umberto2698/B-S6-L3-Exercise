package lezione22.enteties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.UUID;
@Getter
@ToString
@Setter
public class Author {
    private UUID id;
    private String name;
    private String surname;
    private String email;
    private LocalDate birthday;
    private String avatar;
}
