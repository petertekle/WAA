package N_tier.example.Lab1.controller;

import N_tier.example.Lab1.entity.Post;
import N_tier.example.Lab1.dtos.PostDTO;
import N_tier.example.Lab1.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping("")
    public ResponseEntity<List<PostDTO>> getAllPosts() {
        return new ResponseEntity<>(postService.getAllPosts(), HttpStatus.OK);
    }
    @GetMapping("/{postId}")
    public ResponseEntity<PostDTO> getPost(@PathVariable long postId) {
        return postService.getPost(postId)
                .map(postDTO -> new ResponseEntity<>(postDTO, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping("")
    public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDTO) {
        Post post = new Post();
        post.setTitle(postDTO.getTitle());
        postService.createPost(post);
        return new ResponseEntity<>(new PostDTO(post), HttpStatus.CREATED);
    }
    @GetMapping("/title/{title}")
    public ResponseEntity<List<PostDTO>> getPostsByTitle(@PathVariable String title) {
        return new ResponseEntity<>(postService.getPostsByTitle(title), HttpStatus.OK);
    }
}
