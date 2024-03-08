package cm.tech.com.makeshift_reddits_apis.entities.dto;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CommentDTO {

    private Long id;
    private String content;
    private int upvoteCount;
    private int downvoteCount;
}
