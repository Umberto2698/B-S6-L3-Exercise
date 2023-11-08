package lezione22.controllers;

import lezione22.enteties.BlogPost;
import lezione22.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/blogposts")
public class BlogPostController {
    @Autowired
    private BlogPostService blogPostService;

    @GetMapping("")
    public List<BlogPost> blogPosts() {
        return blogPostService.getAllBlogPost();
    }

    @GetMapping("/{id}")
    public BlogPost getBlogPost(@PathVariable UUID id) {
        return blogPostService.getById(id);
    }

    @PostMapping("")
    public BlogPost saveBlogPost(@RequestBody BlogPost body) {
        return blogPostService.save(body);
    }

    @PutMapping("/{id}")
    public BlogPost updateBlogPost(@PathVariable UUID id, @RequestBody BlogPost body) {
        return blogPostService.update(id, body);
    }

    @DeleteMapping("/{id}")
    public void deleteBlogPost(@PathVariable UUID id) {
        blogPostService.delete(id);
    }
}
