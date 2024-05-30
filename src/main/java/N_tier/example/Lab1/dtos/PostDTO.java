package N_tier.example.Lab1.dtos;

import N_tier.example.Lab1.entity.Post;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDTO {
    long id;
    String  title;

    public PostDTO(Post p) {
        this.id = p.getId();
        this.title = p.getTitle();
    }
}
