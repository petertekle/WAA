package N_tier.example.Lab1.service;

import N_tier.example.Lab1.dtos.CommentDTO;
import N_tier.example.Lab1.entity.Comment;
import N_tier.example.Lab1.repository.CommentRepository;
import N_tier.example.Lab1.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    PostRepository postRepository;

    @Override
    public void createComment(Comment c) {
        commentRepository.save(c);
    }

    @Override
    public List<CommentDTO> getAllComments() {
        List<Comment> comments = commentRepository.findAll();
        List<CommentDTO> commentDTOS = new ArrayList<>();
        for (Comment c: comments){
            commentDTOS.add(new CommentDTO(c));
        }
        return commentDTOS;
    }

    @Override
    public Optional<CommentDTO> getComment(long commentId) {
        return commentRepository.findById(commentId).map(CommentDTO::new);
    }

    @Override
    public Optional<Comment> addCommentToPost(long postId, Comment comment) {
        return postRepository.findById(postId).map(post -> {
            commentRepository.save(comment);
            post.getComments().add(comment);
            postRepository.save(post);
            return comment;
        });
    }

    @Override
    public List<CommentDTO> getCommentsByPostId(long postId) {
        Optional<Comment> comments = commentRepository.findByPostId(postId);
        return comments.stream().map(CommentDTO::new).collect(Collectors.toList());
    }

}
