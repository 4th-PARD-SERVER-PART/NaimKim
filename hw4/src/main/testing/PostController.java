package pard.server.hw4.testing;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    @PostMapping("/{userId}")
    public ResponseEntity<String> createPost (@PathVariable Long userId, @RequestBody PostRequestDto.PostCreateRequest req){
        postService.createPost(userId, req);
        return ResponseEntity.status(HttpStatus.CREATED).body("저장되었습니다.");
    }

    @GetMapping("")
    public ResponseEntity<List<PostResponseDto.PostRead>> findAll(){
        return ResponseEntity.ok(postService.findAll());
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostResponseDto.PostRead> findById(@PathVariable Long postId){
        return ResponseEntity.ok(postService.findById(postId));
    }

    @PatchMapping("/{postId}/{userId}")
    public ResponseEntity<String> patchPost(@PathVariable Long userId, @PathVariable Long postId, @RequestBody PostRequestDto.PostCreateRequest req){
        boolean ret = postService.patchPost(userId, postId , req);
        if (!ret){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("해당 게시물의 작성자가 아닙니다");
        }
        else return ResponseEntity.ok("수정되었습니다.");
    }

    @DeleteMapping("/{postId}/{userId}")
    public ResponseEntity<String> deletePost(@PathVariable Long postId, @PathVariable Long userId){
        boolean ret = postService.deletePost(postId, userId);
        if (!ret){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("해당 게시물의 작성자가 아닙니다");
        }
        else return ResponseEntity.ok("삭제되었습니다.");
    }
}
