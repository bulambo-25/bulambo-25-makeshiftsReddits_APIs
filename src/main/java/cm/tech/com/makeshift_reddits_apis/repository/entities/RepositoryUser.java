package cm.tech.com.makeshift_reddits_apis.repository.entities;

import cm.tech.com.makeshift_reddits_apis.entities.*;
import cm.tech.com.makeshift_reddits_apis.expection.ApiException;
import cm.tech.com.makeshift_reddits_apis.repository.Implementation.*;
import cm.tech.com.makeshift_reddits_apis.repository.Implementation.IRepository.IUserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@Repository
@Transactional
@AllArgsConstructor
public class RepositoryUser implements IUserRepository {

    private final UserRepository userRepository;
    private final PostRepository repositoryPost;
    private final CommentRepository repositoryComment;
    private final VoteRepository repositoryVote;
    private PasswordEncoder passwordEncoder;
    private RoleRepository roleRepository;
    @Override
    public User create(User user) {


            if (user.getUsername() == null || user.getUsername().isEmpty()) {
                throw new IllegalArgumentException("Username cannot be null or empty");
            }
            if (userRepository.existsByUsername(user.getUsername())) {
                throw new ApiException("username already Exist");
            }
            if (user.getPassword() == null || user.getPassword().isEmpty()) {
                throw new IllegalArgumentException("Password cannot be null or empty");
            }
            checkAndCreateRole();
        // Encode the password
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            // Find the role named "ROLE_USER"
            Role role = roleRepository.findByName("ROLE_USER");
            // Validate if the role exists
            if (role == null) {
                throw new ApiException("ROLE_USER does not exist");
            }
            Set<Role> roles = new HashSet<>();
            roles.add(role);
            // Create the user with the encoded password and assigned role
            User newUser = User.builder().username(user.getUsername())
                    .password(encodedPassword).roles(roles).build();
            User savedUser = userRepository.save(newUser);
            return savedUser;
        }

    @Override
    public User getById(Long id) {
        User user1=userRepository.UserFindById(id);
        return user1;
    }
    public User findUserByIdSurname(String username) {
        return userRepository.findUserByIdSurname(username);
    }
    @Override
    public void deleteById(Long id) {
        this.userRepository.deleteById(Long.valueOf(id));
    }


    @Override
    public void upVotePost(Long user_id, Long post_id) {
        User user = getById(user_id);
        Post post = repositoryPost.getById(post_id);
        Vote vote=Vote.builder().user(user).post(post).type(VoteType.UPVOTE).build();
        Vote vote1 =repositoryVote.save(vote);
        post.getUpvotersPost().add(vote1);
    }
    @Override
    public void downVotePost(Long user_id, Long post_id) {
        User user = getById(user_id);
        Post post = repositoryPost.getById(post_id);
        Vote vote=Vote.builder().user(user).post(post).type(VoteType.UPVOTE).build();
        Vote vote1 =repositoryVote.save(vote);
        post.getUpvotersPost().remove(vote1);
    }

    @Override
    public void addCommentPost(Long user_id, Long post_id,String content) {
        User user = getById(user_id);
        Post post = repositoryPost.getById(post_id);
        Comment comment = Comment.builder().post(post).user(user).content(content).build();
        Comment comment1=repositoryComment.save(comment);
        post.getComments().add(comment1);
    }

    @Override
    public void upVoteComment(Long user_id,Long post_id,Long comment_id) {

        User user = getById(user_id);
        Post post = repositoryPost.getById(post_id);
        Comment comment =repositoryComment.getById(comment_id);
        Vote vote=Vote.builder().user(user).post(post).comment(comment).type(VoteType.UPVOTE).build();
        comment.getUpvotersComment().add(vote);
    }

    public List<User> findByAll(){
       return userRepository.findAll();
    }
    public Iterable findUserAll() {

     return    this.userRepository.findAll();
    }


    @Override
    public void downVoteComment(Long user_id,Long post_id,Long comment_id) {
        User user = getById(user_id);
        Post post = repositoryPost.getById(post_id);
        Comment comment =repositoryComment.getById(comment_id);
        Vote vote= Vote.builder().user(user).post(post).comment(comment).type(VoteType.DOWNVOTE).build();
        comment.getUpvotersComment().remove(vote);
    }

    public Role createRole() {
        Role role= Role.builder().name("ROLE_USER").build();
       return  roleRepository.save(role);
    }
    public boolean isRoleTableEmpty() {
        return roleRepository.count() == 0;
    }
    public void checkAndCreateRole() {
        if (isRoleTableEmpty()) {
            createRole();
        }
    }

}
