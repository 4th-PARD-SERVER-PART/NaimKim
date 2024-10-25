package pard.server.hw4.like.dto;

import pard.server.hw4.like.entity.Like;
import pard.server.hw4.post.dto.PostResponseDto;
import pard.server.hw4.post.entity.Post;
import pard.server.hw4.user.dto.UserResponseDto;
import pard.server.hw4.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LikeResponseDto {

    @Getter
    @Builder
    @NoArgsConstructor @AllArgsConstructor
    public static class LikeInfo {
        private Long likeId; // ID of the like entry
        private Long userId; // ID of the user who liked
        private Long postId; // ID of the post liked

        // Convert Like entity to LikeInfo DTO
        public static LikeInfo from(Like like) {
            return new LikeInfo(like.getId(), like.getUser().getId(), like.getPost().getId());
        }
    }
}