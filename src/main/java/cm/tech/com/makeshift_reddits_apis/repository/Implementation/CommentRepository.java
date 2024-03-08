package cm.tech.com.makeshift_reddits_apis.repository.Implementation;


import cm.tech.com.makeshift_reddits_apis.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository  extends JpaRepository<Comment, Long> {

}

