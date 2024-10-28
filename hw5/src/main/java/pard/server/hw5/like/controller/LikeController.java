package pard.server.hw5.like.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pard.server.hw5.like.service.LikeService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/like")
public class LikeController {
    private final LikeService likeService;

    @PostMapping("/{postId}/{userId}")
    public ResponseEntity<String> toggleLike(@PathVariable Long postId, @PathVariable Long userId) {
        String message = likeService.toggleLike(postId, userId);
        return ResponseEntity.status(HttpStatus.OK).body(message); // Returns appropriate message for like/unlike action
    }
}
