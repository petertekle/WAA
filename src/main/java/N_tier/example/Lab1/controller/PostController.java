package N_tier.example.Lab1.controller;

import N_tier.example.Lab1.entity.Post;
import N_tier.example.Lab1.dtos.PostDTO;
import N_tier.example.Lab1.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    PostService productService;

    @GetMapping("")
    List<PostDTO> getAllPosts() { return productService.getAllPosts(); }

    @GetMapping("/{id}")
    Optional<PostDTO> getPost(@PathVariable int id) { return productService.getPost(id); }

    @PostMapping("")
    void create(@RequestBody Post p) { productService.createPost(p);}
}
