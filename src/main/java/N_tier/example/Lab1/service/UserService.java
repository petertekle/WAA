package N_tier.example.Lab1.service;

import N_tier.example.Lab1.dtos.UserDTO;
import N_tier.example.Lab1.entity.User;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public interface UserService {
    List<UserDTO> getAllUsers();
    Optional<UserDTO> getUser(long userId);
    void createUser(User user);

    Optional<User>getUserEntity(long id);

    Optional<User> addPostToUser(long userId, long postId);
}
