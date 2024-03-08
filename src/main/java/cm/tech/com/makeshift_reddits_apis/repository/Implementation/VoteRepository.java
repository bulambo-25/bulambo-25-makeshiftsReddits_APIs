package cm.tech.com.makeshift_reddits_apis.repository.Implementation;


import cm.tech.com.makeshift_reddits_apis.entities.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote, Long> {

}
