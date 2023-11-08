package lezione22.controllers;

import lezione22.enteties.Author;
import lezione22.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping("")
    public Page<Author> getAuthors(@RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "10") int size,
                                   @RequestParam(defaultValue = "id") String orderBy) {
        return authorService.getAuthors(page, size, orderBy);
    }

    @GetMapping("/{id}")
    public Author getAuthor(@PathVariable UUID id) {
        return authorService.getById(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Author saveAuthor(@RequestBody Author body) {
        return authorService.save(body);
    }

    @PutMapping("/{id}")
    public Author updateAuthor(@PathVariable UUID id, @RequestBody Author body) {
        return authorService.update(id, body);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthor(@PathVariable UUID id) {
        authorService.delete(id);
    }
}
