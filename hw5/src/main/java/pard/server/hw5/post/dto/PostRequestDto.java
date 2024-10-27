package pard.server.hw5.post.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
