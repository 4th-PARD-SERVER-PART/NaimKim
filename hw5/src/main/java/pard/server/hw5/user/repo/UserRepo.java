package pard.server.hw5.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pard.server.hw4.user.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {
}
