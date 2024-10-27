package pard.server.hw5.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pard.server.hw4.post.dto.PostResponseDto;
import pard.server.hw4.user.dto.UserRequestDto;
import pard.server.hw4.user.dto.UserResponseDto;
import pard.server.hw4.user.entity.User;
import pard.server.hw4.user.repo.UserRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;

    // Create a new user
    
    public void createUser(UserRequestDto.UserCreateRequest req) {
        User user = new User(null, req.getName(), null);
        userRepo.save(user);
    }

    // Get user details by ID
    public UserResponseDto.UserRead readUser(Long userId) {
        return userRepo.findById(userId)
                .map(UserResponseDto.UserRead::from)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    // Get posts by user ID
    public List<PostResponseDto.PostRead> findPostsByUserId(Long userId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
        return user.getPosts().stream()
                .map(PostResponseDto.PostRead::from)
                .collect(Collectors.toList());
    }

    // Update user name
    
    public void updateUser(Long userId, UserRequestDto.UserPatchRequest req) {
        User user = userRepo.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
        user.setName(req.getName());
        userRepo.save(user);
    }

    // Delete user by ID
    
    public void deleteUser(Long userId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
        userRepo.delete(user);
    }
}
