package cm.tech.com.makeshift_reddits_apis.repository.entities;

import cm.tech.com.makeshift_reddits_apis.entities.Comment;
import cm.tech.com.makeshift_reddits_apis.entities.Post;
import cm.tech.com.makeshift_reddits_apis.entities.User;
import cm.tech.com.makeshift_reddits_apis.repository.Implementation.CommentRepository;
import cm.tech.com.makeshift_reddits_apis.repository.Implementation.IRepository.ICommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Slf4j
@Repository
public class RepositoryComment implements ICommentRepository {

    private final CommentRepository commentRepository;
    private final  RepositoryUser repositoryUser;
    private final  RepositoryPost repositoryPost;
    @Override
    public Comment create(Comment comment) {

        User user =repositoryUser.getById(comment.getUser().getId());
        Post post=repositoryPost.getById(comment.getPost().getId());
        Comment comment1= Comment.builder(). content(comment.getContent())
                .user(user).post(post).build();
        Comment comment2=commentRepository.save(comment1);
        return comment;
    }
    @Override
    public Comment getById(Long id) {
        Comment comment1=commentRepository.getById(id);
        return comment1;
    }
    @Override
    public void deleteById(Long id) {
        this.commentRepository.deleteById(id);
    }
}
