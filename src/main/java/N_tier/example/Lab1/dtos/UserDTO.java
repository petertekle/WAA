package N_tier.example.Lab1.dtos;


import N_tier.example.Lab1.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDTO {
    long id;
    String name;

    public UserDTO(User user){
        this.id = user.getId();
        this.name = user.getName();
    }
}
