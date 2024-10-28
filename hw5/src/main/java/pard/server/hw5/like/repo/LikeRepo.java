package pard.server.hw5.like.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pard.server.hw5.like.entity.Like;
import pard.server.hw5.post.entity.Post;
import pard.server.hw5.user.entity.User;

import java.util.Optional;

public interface LikeRepo extends JpaRepository<Like, Long> {

    // Find like by User and Post combination
    Optional<Like> findByUserAndPost(User user, Post post);
}
