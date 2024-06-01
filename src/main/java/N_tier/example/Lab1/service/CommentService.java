package N_tier.example.Lab1.service;

import N_tier.example.Lab1.dtos.CommentDTO;
import N_tier.example.Lab1.entity.Comment;
import java.util.List;
import java.util.Optional;

public interface CommentService {
    void createComment(Comment c);
    List<CommentDTO> getAllComments();
    Optional<CommentDTO> getComment(long commentId);
    Optional<Comment> addCommentToPost(long postId, Comment comment);
    List<CommentDTO> getCommentsByPostId(long postId);

}
