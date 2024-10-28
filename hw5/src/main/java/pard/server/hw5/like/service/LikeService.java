package pard.server.hw5.like.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pard.server.hw5.like.entity.Like;
import pard.server.hw5.like.repo.LikeRepo;
import pard.server.hw5.post.entity.Post;
import pard.server.hw5.post.repo.PostRepo;
import pard.server.hw5.user.entity.User;
import pard.server.hw5.user.repo.UserRepo;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LikeService {
    private final LikeRepo likeRepo;
    private final UserRepo userRepo;
    private final PostRepo postRepo;

    @Transactional
    public String toggleLike(Long postId, Long userId) {
        Post post = postRepo.findById(postId).orElseThrow(() -> new IllegalArgumentException("Post not found"));
        User user = userRepo.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));

        // Check if like exists and toggle it
        Optional<Like> existingLike = likeRepo.findByUserAndPost(user, post);
        if (existingLike.isPresent()) {
            likeRepo.delete(existingLike.get()); // Unlike action
            return "Like removed";
        } else {
            Like like = Like.form(user, post);
            likeRepo.save(like); // Like action
            return "Like added";
        }
    }
}
