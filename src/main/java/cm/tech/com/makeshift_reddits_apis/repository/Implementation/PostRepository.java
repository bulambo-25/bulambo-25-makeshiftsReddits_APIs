package cm.tech.com.makeshift_reddits_apis.repository.Implementation;

import cm.tech.com.makeshift_reddits_apis.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("SELECT p FROM Post p JOIN FETCH p.user WHERE p.user.id = :userId")
    List<Post> findByUserId(@Param("userId") Long userId);

    @Query("SELECT DISTINCT p FROM Post p JOIN p.upvotersPost u WHERE u.id = :userId")
    List<Post> findAllUpvotedByUser(Long userId);

    @Query("SELECT DISTINCT p FROM Post p JOIN p.downvoters u WHERE u.id = :userId")
    List<Post> findAllDownVotersByUser(Long userId);

    @Query("SELECT p FROM Post p WHERE p.user.username = :username")
    List<Post> findAllByUserUsername(String username);





}
