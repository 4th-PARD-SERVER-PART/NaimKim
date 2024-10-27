package pard.server.hw5.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pard.server.hw4.post.dto.PostResponseDto;
import pard.server.hw4.user.entity.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserResponseDto {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserRead {
        private Long id;
        private String name;
        private List<PostResponseDto.PostRead> posts; // List of posts related to the user

        // Converts User entity to UserRead DTO
        public static UserRead from(User user) {
            return new UserRead(
                    user.getId(),
                    user.getName(),
                    user.getPosts().stream().map(PostResponseDto.PostRead::from).collect(Collectors.toList())
            );
        }
    }
}
