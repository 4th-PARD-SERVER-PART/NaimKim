package pard.server.hw5.post.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pard.server.hw5.post.dto.PostRequestDto;
import pard.server.hw5.post.dto.PostResponseDto;
import pard.server.hw5.post.entity.Post;
import pard.server.hw5.post.repo.PostRepo;
import pard.server.hw5.user.entity.User;
import pard.server.hw5.user.repo.UserRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {
    private final UserRepo userRepo;
    private final PostRepo postRepo;

    // Create a new post by a user
    @Transactional
    public void createPost(Long userId, PostRequestDto.PostCreateRequest req) {
        User user = userRepo.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
        Post post = Post.form(req.getTitle(), req.getContent(), user);
        postRepo.save(post);
    }

    // Update post title and content
    @Transactional
    public boolean updatePost(Long userId, Long postId, PostRequestDto.PostCreateRequest req) {
        Post post = postRepo.findById(postId).orElseThrow(() -> new IllegalArgumentException("Post not found"));
        if (!post.getUser().getId().equals(userId)) {
            return false; // Unauthorized
        }
        post.updatePost(req.getTitle(), req.getContent()); // Update post details
        return true;
    }

    // Get all posts as a list of PostRead DTOs
    public List<PostResponseDto.PostRead> findAll() {
        return postRepo.findAll().stream()
                .map(PostResponseDto.PostRead::from)
                .collect(Collectors.toList());
    }

    // Find post by ID
    public PostResponseDto.PostRead findById(Long postId) {
        Post post = postRepo.findById(postId).orElseThrow(() -> new IllegalArgumentException("Post not found"));
        return PostResponseDto.PostRead.from(post);
    }

    // Delete post if the user is the author
    @Transactional
    public boolean deletePost(Long postId, Long userId) {
        Post post = postRepo.findById(postId).orElseThrow(() -> new IllegalArgumentException("Post not found"));
        if (!post.getUser().getId().equals(userId)) {
            return false; // Unauthorized
        }
        postRepo.delete(post);
        return true;
    }
}
