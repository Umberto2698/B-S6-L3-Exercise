package lezione22.services;

import lezione22.enteties.BlogPost;
import lezione22.exceptions.ItemoNotFoundException;
import lezione22.repositories.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class BlogPostService {

    @Autowired
    private BlogPostRepository blogPostRepository;

    public Page<BlogPost> getAllBlogPost(int page, int size, String orderBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(orderBy));

        return blogPostRepository.findAll(pageable);
    }

    public BlogPost save(BlogPost blogPost) {
        blogPost.setId(UUID.randomUUID());
        blogPost.setCover("https://picsum.photos/200/300");
        blogPost.setReadingTime(new Random().nextInt(10, 240));
        return blogPostRepository.save(blogPost);
    }

    public BlogPost getById(UUID id) {
        return blogPostRepository.findById(id).orElseThrow(() -> new ItemoNotFoundException(id));
    }

    public BlogPost update(UUID id, BlogPost body) {
        BlogPost found = this.getById(id);
        found.setReadingTime(body.getReadingTime());
        found.setTitle(body.getTitle());
        found.setContent(body.getContent());
        found.setCategory(body.getCategory());
        return blogPostRepository.save(found);
    }

    public void delete(UUID id) {
        BlogPost found = this.getById(id);
        blogPostRepository.delete(found);
    }
}
