package pard.server.hw5.post.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pard.server.hw4.post.entity.Post;

public interface PostRepo extends JpaRepository<Post, Long> {
}
