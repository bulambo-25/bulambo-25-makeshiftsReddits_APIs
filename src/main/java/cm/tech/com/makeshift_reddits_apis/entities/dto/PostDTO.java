package cm.tech.com.makeshift_reddits_apis.entities.dto;

import lombok.*;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class PostDTO {
    private Long id;
    private String title;
    private String content;
    private int upvoteCount;
    private int downvoteCount;
    private List<CommentDTO> comments;
}
