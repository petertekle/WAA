package N_tier.example.Lab1.controller;

import N_tier.example.Lab1.dtos.CommentDTO;
import N_tier.example.Lab1.entity.Comment;
import N_tier.example.Lab1.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping("")
    public ResponseEntity<List<CommentDTO>> getAllComments(){
        return new ResponseEntity<>(commentService.getAllComments(), HttpStatus.OK) ;
    }

    @GetMapping("/{commentId}")
    public ResponseEntity<CommentDTO> getComment(@PathVariable long commentId){
        return commentService.getComment(commentId)
                .map(commentDTO -> new ResponseEntity<>(commentDTO, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/post/{postId}")
    public ResponseEntity<CommentDTO> addCommentToPost(@PathVariable long postId, @RequestBody CommentDTO commentDTO) {
        Comment comment = new Comment();
        comment.setName(commentDTO.getName());

        Optional<Comment> createdComment = commentService.addCommentToPost(postId, comment);
        return createdComment.map(value -> new ResponseEntity<>(new CommentDTO(value), HttpStatus.CREATED))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<List<CommentDTO>> getCommentsByPostId(@PathVariable long postId) {
        List<CommentDTO> comments = commentService.getCommentsByPostId(postId);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }
}