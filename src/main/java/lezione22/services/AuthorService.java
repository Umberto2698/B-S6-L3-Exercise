package lezione22.services;

import lezione22.enteties.Author;
import lezione22.exceptions.ItemoNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AuthorService {
    private List<Author> authorList = new ArrayList<>();

    public List<Author> getAllAuthor() {
        return this.authorList;
    }

    public Author save(Author author) {
        author.setId(UUID.randomUUID());
        author.setAvatar("https://ui-avatars.com/api/?name=" + author.getName() + "+" + author.getSurname());
        this.authorList.add(author);
        return author;
    }

    public Author getById(UUID id) {
        Author author = null;
        for (Author a : this.authorList) {
            if (a.getId().compareTo(id) == 0) {
                author = a;
            }
        }
        if (author != null) {
            return author;
        } else {
            throw new ItemoNotFoundException(id);
        }
    }

    public Author update(UUID id, Author body) {
        Author found = null;
        for (Author author : this.authorList) {
            if (author.getId().compareTo(id) == 0) {
                found = author;
                found.setId(id);
                found.setBirthday(body.getBirthday());
                found.setName(body.getName());
                found.setSurname(body.getSurname());
                found.setEmail(body.getEmail());
                found.setAvatar("https://ui-avatars.com/api/?name=" + body.getName() + "+" + body.getSurname());
            }
        }
        if (found != null) {
            return found;
        } else {
            throw new ItemoNotFoundException(id);
        }
    }

    public void delete(UUID id) {
        this.authorList.removeIf(author -> author.getId().compareTo(id) == 0);
    }
}
