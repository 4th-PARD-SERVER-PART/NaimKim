package pard.server.hw5.post.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pard.server.hw5.post.dto.PostRequestDto;
import pard.server.hw5.post.dto.PostResponseDto;
import pard.server.hw5.post.service.PostService;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    @PostMapping("/{userId}")
    public ResponseEntity<String> createPost(@PathVariable Long userId, @RequestBody PostRequestDto.PostCreateRequest req) {
        postService.createPost(userId, req);
        return ResponseEntity.status(HttpStatus.CREATED).body("Post created successfully"); // Improved response message
    }

    @GetMapping("")
    public ResponseEntity<List<PostResponseDto.PostRead>> findAll() {
        return ResponseEntity.ok(postService.findAll()); // Get list of all posts
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostResponseDto.PostRead> findById(@PathVariable Long postId) {
        return ResponseEntity.ok(postService.findById(postId)); // Get post by ID
    }

    @PatchMapping("/{postId}/{userId}")
    public ResponseEntity<String> updatePost(@PathVariable Long userId, @PathVariable Long postId, @RequestBody PostRequestDto.PostCreateRequest req) {
        boolean isUpdated = postService.updatePost(userId, postId, req);
        return isUpdated ? ResponseEntity.ok("Post updated successfully") :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body("Unauthorized or post not found");
    }

    @DeleteMapping("/{postId}/{userId}")
    public ResponseEntity<String> deletePost(@PathVariable Long postId, @PathVariable Long userId) {
        boolean isDeleted = postService.deletePost(postId, userId);
        return isDeleted ? ResponseEntity.ok("Post deleted successfully") :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body("Unauthorized or post not found");
    }
}
