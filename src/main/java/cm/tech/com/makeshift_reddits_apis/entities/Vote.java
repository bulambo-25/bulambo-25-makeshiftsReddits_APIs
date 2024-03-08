package cm.tech.com.makeshift_reddits_apis.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@SuperBuilder
public class Vote  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private VoteType type;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user; // The voter

    @ManyToOne
    @JoinColumn(name = "post_id")
    @JsonIgnore
    private Post post; // The post being voted on

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment; // The comment being voted on

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public VoteType getType() {
        return type;
    }

    public void setType(VoteType type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

}

