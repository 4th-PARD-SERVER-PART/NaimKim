package pard.server.hw5.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pard.server.hw5.post.dto.PostResponseDto;
import pard.server.hw5.user.dto.UserRequestDto;
import pard.server.hw5.user.dto.UserResponseDto;
import pard.server.hw5.user.service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseDto.UserRead> getUser(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.readUser(userId)); // Get user by ID
    }

    @GetMapping("/{userId}/posts")
    public ResponseEntity<List<PostResponseDto.PostRead>> findPostsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.findPostsByUserId(userId)); // Get posts by user ID
    }

    @PostMapping("")
    public ResponseEntity<String> createUser(@RequestBody UserRequestDto.UserCreateRequest req) {
        userService.createUser(req);
        return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");
    }

    @PatchMapping("/{userId}")
    public ResponseEntity<String> updateUser(@PathVariable Long userId, @RequestBody UserRequestDto.UserPatchRequest req) {
        userService.updateUser(userId, req);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("User updated successfully");
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("User deleted successfully");
    }
}
