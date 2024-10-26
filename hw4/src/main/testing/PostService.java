package pard.server.hw4.testing;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final UserRepo userRepo;
    private final PostRepo postRepo;

    public void createPost(Long userid, PostRequestDto.PostCreateRequest req){
        Optional<User> u = userRepo.findById(userid);
        User user = u.get();
        Post post = Post.form(req.getTitle(), req.getContent(), user);
        postRepo.save(post);
    }

    public boolean patchPost(Long userid, Long postid, PostRequestDto.PostCreateRequest req){
        Optional<User> u = userRepo.findById(userid);
        User user = u.get();

        Optional<Post> p = postRepo.findById(postid);
        Post post = p.get();
        if(post.getUser().getId() != user.getId()) {
            return false;
        }

        post.setPost(req.getTitle(), req.getContent());
        postRepo.save(post);
        return true ;
    }

    public List<PostResponseDto.PostRead> findAll(){
        List<PostResponseDto.PostRead> postReads = new ArrayList<>(); // 새로운 리스트 생성
        List<Post> posts = postRepo.findAll();

        for (Post post : posts) {
            PostResponseDto.PostRead postRead = PostResponseDto.PostRead.from(post); // 포스트를 PostRead로 변환
            postReads.add(postRead);
        }

        return postReads;
    }

    public PostResponseDto.PostRead findById(Long postId){
        Optional<Post> p = postRepo.findById(postId);
        Post post = p.get();

        PostResponseDto.PostRead postRead = PostResponseDto.PostRead.from(post);

        return postRead;
    }

    public boolean deletePost(Long postId, Long userId){
        Optional<Post> p = postRepo.findById(postId);
        Post post = p.get();

        Optional<User> u = userRepo.findById(userId);
        User user = u.get();
        if(post.getUser().getId() != user.getId()) {
            return false;
        }

        postRepo.delete(post);
        return true;
    }
}
