package pard.server.hw4.like.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class LikeRequestDto {

    @Getter
    @Builder
    @NoArgsConstructor @AllArgsConstructor
    public static class LikeCreateRequest {
        private Long userId;
        private Long postId;
    }
}