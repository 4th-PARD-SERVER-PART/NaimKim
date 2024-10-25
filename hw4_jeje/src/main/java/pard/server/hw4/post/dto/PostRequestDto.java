package pard.server.hw4.post.dto;

import jakarta.validation.constraints.NotBlank;
import pard.server.hw4.like.entity.Like;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public class PostRequestDto {

    @Getter
    @JsonInclude(JsonInclude.Include.NON_NULL) // Include non-null fields only
    @NoArgsConstructor @AllArgsConstructor
    public static class PostCreateRequest {
        @NotBlank // Validation to ensure non-empty title
        private String title;

        @NotBlank // Validation to ensure non-empty content
        private String content;
    }
}
