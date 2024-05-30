package N_tier.example.Lab1.controller;

import N_tier.example.Lab1.dtos.UserDTO;
import N_tier.example.Lab1.entity.Post;
import N_tier.example.Lab1.entity.User;
import N_tier.example.Lab1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    Optional<UserDTO> getPost(@PathVariable int id){
        return userService.getUser(id);
    }

    @PostMapping
    void create(@RequestBody User user){
        userService.createUser(user);
    }

    @GetMapping("/{id}/posts")
    public ResponseEntity<List<Post>> getUserPosts(@PathVariable long id) {
        Optional<User> user = userService.getUserEntity(id);
        return user.map(value -> ResponseEntity.ok(value.getPosts())).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/{userId}/posts/{postId}")
    public ResponseEntity<User> addPostToUser(@PathVariable long userId, @PathVariable long postId){
        Optional<User> user = userService.addPostToUser(userId, postId);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
