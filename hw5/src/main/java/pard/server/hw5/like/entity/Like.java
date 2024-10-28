package pard.server.hw5.like.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pard.server.hw5.post.entity.Post;
import pard.server.hw5.user.entity.User;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "post_like")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne // Defines many-to-one relationship with User
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne // Defines many-to-one relationship with Post
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    // Factory method for creating Like instance
    public static Like form(User user, Post post) {
        return new Like(null, user, post); // ID is auto-generated
    }
}
