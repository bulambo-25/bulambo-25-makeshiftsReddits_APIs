package cm.tech.com.makeshift_reddits_apis.repository.Implementation.IRepository;


import cm.tech.com.makeshift_reddits_apis.entities.Post;

import java.util.List;

public interface IPostRepository  extends IRepository<Post,Long> {

    List<Post> findPostsByUser(Long id);

    Post updatePost(Post post);
    List<Post> findAllUpvotedByUser(Long userId);
    List<Post> findAllDownVotersByUser(Long userId);
    List<Post> findAllByUserUsername(String username);


}
