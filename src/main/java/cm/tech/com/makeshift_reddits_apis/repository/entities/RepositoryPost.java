package cm.tech.com.makeshift_reddits_apis.repository.entities;


import cm.tech.com.makeshift_reddits_apis.entities.Post;
import cm.tech.com.makeshift_reddits_apis.entities.User;
import cm.tech.com.makeshift_reddits_apis.entities.dto.CommentDTO;
import cm.tech.com.makeshift_reddits_apis.entities.dto.PostDTO;
import cm.tech.com.makeshift_reddits_apis.repository.Implementation.IRepository.IPostRepository;
import cm.tech.com.makeshift_reddits_apis.repository.Implementation.PostRepository;
import cm.tech.com.makeshift_reddits_apis.repository.Implementation.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@RequiredArgsConstructor
@Slf4j
@Repository
public class RepositoryPost  implements IPostRepository {

    private final PostRepository postRepository;
    private final UserRepository userRepository;


    @Override
    public Post create(Post post) {
        log.info("get the id "+post.getUser().getId());
        User user=userRepository.UserFindById(post.getUser().getId());
        log.info("get the id "+user);
        Post post1=Post.builder().title(post.getTitle()).user(user).content(post.getContent()).build();

        Post post2=postRepository.save(post1);
        return post2;
    }

    @Override
    public List<Post> findPostsByUser(Long id) {

        List<Post> listOfPost=postRepository.findByUserId(id);
        return listOfPost;
    }

    @Override
    public Post updatePost(Post post) {
        Post post1= getById(post.getId());
        post1.setTitle(post.getTitle());
        post1.setContent(post.getContent());
        Post post2=postRepository.save(post1);
        return post2;
    }

    @Override
    public List<Post> findAllUpvotedByUser(Long userId) {
        List<Post> list=postRepository.findAllUpvotedByUser(userId);
        return list;
    }

    @Override
    public List<Post> findAllDownVotersByUser(Long userId) {
        List<Post> list=postRepository.findAllDownVotersByUser(userId);
        return list;

    }

    @Override
    public List<Post> findAllByUserUsername(String username) {
        List<Post> list=postRepository.findAllByUserUsername(username);
        return list;
    }


    public List<PostDTO> viewAllPostsWithCommentsAndVoteCounts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }
    private PostDTO mapToDTO(Post post) {
        int upvoteCount = post.getUpvotersPost().size();
        int downvoteCount = post.getDownvoters().size();

        List<CommentDTO> commentDTOs = post.getComments().stream()
                .map(comment -> new CommentDTO(
                        comment.getId(),
                        comment.getContent(),
                        comment.getUpvotersComment().size(),
                        comment.getDownvoters().size()))
                .collect(Collectors.toList());

        return new PostDTO(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                upvoteCount,
                downvoteCount,
                commentDTOs
        );
    }

    @Override
    public Post getById(Long id) {
        Post findPostByPost=postRepository.getById(id);
        return findPostByPost;
    }




    @Override
    public void deleteById(Long id) {

        this.postRepository.deleteById(id);
    }
}
