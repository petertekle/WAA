package N_tier.example.Lab1.service;

import N_tier.example.Lab1.entity.Post;
import N_tier.example.Lab1.dtos.PostDTO;
import java.util.List;
import java.util.Optional;

public interface PostService {
    void createPost(Post p);
    List<PostDTO> getAllPosts();
    Optional<PostDTO> getPost(long postId);
}
