package pard.server.hw4.user.dto;

import jakarta.validation.constraints.NotBlank;
import pard.server.hw4.post.entity.Post;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public class UserRequestDto {

    @Getter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NoArgsConstructor @AllArgsConstructor
    public static class UserCreateRequest {
        @NotBlank // Ensures name is provided on creation
        private String name;
    }

    @Getter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NoArgsConstructor @AllArgsConstructor
    public static class UserPatchRequest {
        @NotBlank // Ensures name is provided on update
        private String name;
    }
}
