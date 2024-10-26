package pard.server.hw4.testing;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/like")
public class LikeController {
    private final LikeService likeService;

    @PostMapping("/{postId}/{userId}")
    public ResponseEntity<String> createLike (@PathVariable Long postId, @PathVariable Long userId){
        likeService.createLike(postId, userId);
        return ResponseEntity.status(HttpStatus.CREATED).body("저장되었습니다.");
    }
}
