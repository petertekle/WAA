package N_tier.example.Lab1.service;

import N_tier.example.Lab1.dtos.UserDTO;
import N_tier.example.Lab1.entity.Post;
import N_tier.example.Lab1.entity.User;
import N_tier.example.Lab1.repository.PostRepository;
import N_tier.example.Lab1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(UserDTO::new).collect(Collectors.toList());
    }

    @Override
    public Optional<UserDTO> getUser(long userId) {
        return userRepository.findById(userId)
                .map(user -> new UserDTO(user.getId(), user.getName()));
    }

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    public Optional<User> getUserEntity(long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> addPostToUser(long userId, long postId) {
        Optional<Post> postOptional = postRepository.findById(postId);

        if (postOptional.isEmpty()) {
            return Optional.empty();
        }

        Post post = postOptional.get();

        return userRepository.findById(userId).map(user -> {
            user.getPosts().add(post);
            userRepository.save(user);
            return user;
        });
    }
}

