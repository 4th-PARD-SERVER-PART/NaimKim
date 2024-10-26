package pard.server.hw4.post.dto;


import pard.server.hw4.like.dto.LikeResponseDto;
import pard.server.hw4.post.entity.Post;
import pard.server.hw4.like.entity.Like;
import pard.server.hw4.user.dto.UserResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

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
