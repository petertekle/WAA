package N_tier.example.Lab1.service;

import N_tier.example.Lab1.entity.Post;
import N_tier.example.Lab1.dtos.PostDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PostService {
    void createPost(Post p);
    List<PostDTO> getAllPosts();
    Optional<PostDTO> getPost(long postId);
    List<PostDTO> getPostsByTitle(String title);
}
