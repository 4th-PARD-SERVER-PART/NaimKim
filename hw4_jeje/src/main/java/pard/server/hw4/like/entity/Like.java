package pard.server.hw4.like.entity;

import pard.server.hw4.post.entity.Post;
import pard.server.hw4.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
