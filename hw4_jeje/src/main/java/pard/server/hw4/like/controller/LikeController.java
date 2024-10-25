package pard.server.hw4.like.controller;

import pard.server.hw4.like.dto.LikeRequestDto;
import pard.server.hw4.like.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
