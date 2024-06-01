package N_tier.example.Lab1.service;

import N_tier.example.Lab1.entity.Post;
import N_tier.example.Lab1.dtos.PostDTO;
import N_tier.example.Lab1.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostRepository postRepository;

    @Override
    public void createPost(Post p) {
        postRepository.save(p);}

    @Override
    public List<PostDTO> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        List<PostDTO> postDTOS = new ArrayList<>();
        for(Post p: posts){
            postDTOS.add(new PostDTO(p));
        }
        return postDTOS;
    }

    @Override
    public Optional<PostDTO> getPost(long postId) {
        return postRepository.findById(postId).map(PostDTO::new);
    }

    @Override
    public List<PostDTO> getPostsByTitle(String title) {
        List<Post> posts = postRepository.findByTitle(title);
        return posts.stream().map(PostDTO::new).collect(Collectors.toList());
    }
}
