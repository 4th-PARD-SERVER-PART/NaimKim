package pard.server.hw5.post.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pard.server.hw4.like.entity.Like;
import pard.server.hw4.user.entity.User;

import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    @ManyToOne // Relationship to User entity
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "post")
    private List<Like> likes;

    // Factory method to create a new Post instance with a default likes list
    public static Post form(String title, String content, User user) {
        return new Post(null, title, content, user, null); // Default 'null' for likes
    }

    // Method to update post content
    public void updatePost(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
