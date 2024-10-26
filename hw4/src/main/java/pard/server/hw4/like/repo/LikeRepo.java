package pard.server.hw4.like.repo;

import pard.server.hw4.like.entity.Like;
import pard.server.hw4.post.entity.Post;
import pard.server.hw4.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeRepo extends JpaRepository<Like, Long> {

    // Find like by User and Post combination
    Optional<Like> findByUserAndPost(User user, Post post);
}
