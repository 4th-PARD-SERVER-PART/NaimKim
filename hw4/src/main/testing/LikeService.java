package pard.server.hw4.testing;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LikeService {
    private final LikeRepo likeRepo;
    private final UserRepo userRepo;
    private final PostRepo postRepo;

    public void createLike(Long postId, Long userId){
        Optional<Post> p = postRepo.findById(postId);
        Post post = p.get();
        Optional<User> u = userRepo.findById(userId);
        User user = u.get();

        Like existingLike = likeRepo.findByUserAndPost(user, post).orElse(null);

        if (existingLike != null) {  // 이미 좋아요가 존재하면 취소
            likeRepo.delete(existingLike);
        }
        else {
            Like like = Like.form(user, post);
            likeRepo.save(like);
        }
    }
}
