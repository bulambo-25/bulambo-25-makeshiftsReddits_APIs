package cm.tech.com.makeshift_reddits_apis.repository.entities;


import cm.tech.com.makeshift_reddits_apis.entities.Vote;
import cm.tech.com.makeshift_reddits_apis.repository.Implementation.IRepository.IVote;
import cm.tech.com.makeshift_reddits_apis.repository.Implementation.VoteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Slf4j
@Repository
public class RepositoryVote implements IVote {

    private final VoteRepository voteRepository;

    @Override
    public Vote create(Vote vote) {
        Vote vote1=Vote.builder().type(vote.getType()).user(vote.getUser()).build();
        Vote vote2=voteRepository.save(vote1);
        return vote2;
    }

    @Override
    public Vote getById(Long id) {
        Vote vote=voteRepository.getById(id);
        return vote;
    }

    @Override
    public void deleteById(Long id) {
    this.voteRepository.deleteById(id);
    }
}
