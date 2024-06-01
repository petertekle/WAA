package N_tier.example.Lab1.dtos;

import N_tier.example.Lab1.entity.Comment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDTO {
    long id;
    String name;

    public CommentDTO(Comment c){
        this.id = c.getId();
        this.name = c.getName();
    }
}