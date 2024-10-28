package pard.server.hw5.post.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pard.server.hw5.post.entity.Post;

public class PostResponseDto {
    @Getter
    @Builder
    @NoArgsConstructor @AllArgsConstructor
    public static class PostRead {
        private String title;
        private String content;
        private int likeCount; // Like count for the post

        // Convert Post entity to PostRead DTO
        public static PostRead from(Post post) {
            return new PostRead(
                    post.getTitle(),
                    post.getContent(),
                    post.getLikes() != null ? post.getLikes().size() : 0 // Count likes safely
            );
        }
    }
}
