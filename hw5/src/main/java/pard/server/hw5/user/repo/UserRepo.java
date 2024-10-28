package pard.server.hw5.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pard.server.hw5.user.entity.User;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    // look for deuplicates
    Optional<User> findByEmail(String email);

}
