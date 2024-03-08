package cm.tech.com.makeshift_reddits_apis.service;


import cm.tech.com.makeshift_reddits_apis.entities.Post;
import cm.tech.com.makeshift_reddits_apis.entities.dto.PostDTO;
import cm.tech.com.makeshift_reddits_apis.repository.entities.RepositoryPost;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostService {

    private final RepositoryPost repositoryPost;

    public Post createPost(Post post) {
        Post post2=repositoryPost.create(post);
        return post2;
    }
    public Post updatePost(Post post) {
        Post post2=repositoryPost.updatePost(post);
        return post2;
    }
    public Post findPostByPostId(Long id) {
        Post post=repositoryPost.getById(id);
        return post;
    }

    public List<Post> findPostsByUser(Long id) {
        List<Post> listOfPostByUser=repositoryPost.findPostsByUser(id);
        return listOfPostByUser;
    }
    public List<Post> findAllUpvotedByUser(Long userId) {
        List<Post> list=repositoryPost.findAllUpvotedByUser(userId);
        return list;
    }
    public List<Post> findAllDownVotersByUser(Long userId) {
        List<Post> list=repositoryPost.findAllDownVotersByUser(userId);
        return list;

    }
    public List<Post> findAllByUserUsername(String username) {
        List<Post> list=repositoryPost.findAllByUserUsername(username);
        return list;
    }

    public List<PostDTO> viewAllPostsWithCommentsAndVoteCounts() {
        return this.repositoryPost.viewAllPostsWithCommentsAndVoteCounts();
    }


    public void deletePostById(Long id) {

        this.repositoryPost.deleteById(id);
    }
}
