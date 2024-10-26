package pard.server.hw4.testing;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeRepo extends JpaRepository<Like, Long> {

    Optional<Like> findByUserAndPost(User user, Post post);
}
