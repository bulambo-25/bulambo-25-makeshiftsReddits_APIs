package cm.tech.com.makeshift_reddits_apis.repository.Implementation.IRepository;

import cm.tech.com.makeshift_reddits_apis.entities.User;

public interface IUserRepository extends IRepository<User,Long> {


     void upVotePost(Long user_id, Long post_id) ;
     void downVotePost(Long user_id, Long post_id) ;
     void addCommentPost(Long user_id, Long post_id,String content) ;
     void upVoteComment(Long user_id,Long post_id,Long comment_id) ;
     void downVoteComment(Long user_id,Long post_id,Long comment_id) ;

}
