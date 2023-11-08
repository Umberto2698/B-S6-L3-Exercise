package lezione22.controllers;

import lezione22.enteties.BlogPost;
import lezione22.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/blogposts")
public class BlogPostController {
    @Autowired
    private BlogPostService blogPostService;

    @GetMapping("")
    public Page<BlogPost> blogPosts(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "id") String orderBy) {
        return blogPostService.getAllBlogPost(page, size, orderBy);
    }

    @GetMapping("/{id}")
    public BlogPost getBlogPost(@PathVariable UUID id) {
        return blogPostService.getById(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public BlogPost saveBlogPost(@RequestBody BlogPost body) {
        return blogPostService.save(body);
    }

    @PutMapping("/{id}")
    public BlogPost updateBlogPost(@PathVariable UUID id, @RequestBody BlogPost body) {
        return blogPostService.update(id, body);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBlogPost(@PathVariable UUID id) {
        blogPostService.delete(id);
    }
}
