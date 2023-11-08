package lezione22.enteties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
@Setter
public class BlogPost {
    private UUID id;
    private String category;
    private String cover;
    private String title;
    private String content;
    private int readingTime;
}
