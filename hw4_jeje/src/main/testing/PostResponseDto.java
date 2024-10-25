package pard.server.hw4.testing;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class PostResponseDto {
    @Getter
    @Builder
    @NoArgsConstructor @AllArgsConstructor
    public static class PostRead{
        private String title;
        private String content;
        private int likeCount;

        public static PostRead from(Post post){
            return new PostRead(
                    post.getTitle(),
                    post.getContent(),
                    countLikes(post)
                    );
        }

        private static int countLikes(Post post) {
            return post.getLikes().size(); //post.getLikes().stream().count() 사용
        }

    }
}
