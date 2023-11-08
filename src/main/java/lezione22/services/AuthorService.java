package lezione22.services;

import lezione22.enteties.Author;
import lezione22.exceptions.ItemoNotFoundException;
import lezione22.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public Page<Author> getAuthors(int page, int size, String orderBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(orderBy));
        return authorRepository.findAll(pageable);
    }

    public Author save(Author author) {
        author.setId(UUID.randomUUID());
        author.setAvatar("https://ui-avatars.com/api/?name=" + author.getName() + "+" + author.getSurname());

        return authorRepository.save(author);
    }

    public Author getById(UUID id) {
        return authorRepository.findById(id).orElseThrow(() -> new ItemoNotFoundException(id));
    }

    public Author update(UUID id, Author body) {
        Author found = this.getById(id);
        found.setBirthday(body.getBirthday());
        found.setName(body.getName());
        found.setSurname(body.getSurname());
        found.setEmail(body.getEmail());
        return authorRepository.save(found);
    }

    public void delete(UUID id) {
        Author found = this.getById(id);
        authorRepository.delete(found);
    }
}
