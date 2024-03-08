package cm.tech.com.makeshift_reddits_apis.service;


import cm.tech.com.makeshift_reddits_apis.entities.Role;
import cm.tech.com.makeshift_reddits_apis.entities.User;
import cm.tech.com.makeshift_reddits_apis.repository.entities.RepositoryRole;
import cm.tech.com.makeshift_reddits_apis.repository.entities.RepositoryUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final RepositoryUser repositoryUser;
    private final RepositoryRole RoleRepository;
    public User createUser(User user) {
        User user1= User.builder().username(user.getUsername()).password(user.getPassword()).build();
        User user2= this.repositoryUser.create(user1);
        return user2;
    }
    public User getUserById(Long id) {
        User user1=repositoryUser.getById(id);
        return user1;
    }
    public User findUserByIdSurname(String username) {
        return repositoryUser.findUserByIdSurname(username);
    }
   public Iterable findAll() {
    return repositoryUser.findByAll();
    }

    public void upVotePost(Long user_id, Long post_id) {
       this.repositoryUser.upVotePost(user_id,post_id);
    }
    public void downVotePost(Long user_id, Long post_id) {
        this.repositoryUser.downVotePost(user_id,post_id);
    }
    public void userAddCommentPost(Long user_id, Long post_id,String content) {
        this.repositoryUser.addCommentPost(user_id,post_id,content);
    }
    public void upVoteComment(Long user_id,Long post_id,Long comment_id) {
        this.repositoryUser.upVoteComment(user_id,post_id,comment_id);
    }
    public void downVoteComment(Long user_id,Long post_id,Long comment_id) {
        this.repositoryUser.downVoteComment(user_id,post_id,comment_id);
    }
    public void deleteUserById(Long id) {
        this.repositoryUser.deleteById(id);
    }

    public Role createRole(Role role) {
        return  this.RoleRepository.create(role);
    }
}
