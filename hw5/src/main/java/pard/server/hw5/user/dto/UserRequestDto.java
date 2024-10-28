package pard.server.hw5.user.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class UserRequestDto {

    @Getter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NoArgsConstructor @AllArgsConstructor
    public static class UserCreateRequest {
        @NotBlank // Ensures name is provided on creation
        private String name;

        @NotBlank
        @Email // email format 확인해줌
        private String email;
    }

    @Getter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NoArgsConstructor @AllArgsConstructor
    public static class UserPatchRequest {
        @NotBlank // Ensures name is provided on update
        private String name;
    }
}
