package cm.tech.com.makeshift_reddits_apis.controller;

import cm.tech.com.makeshift_reddits_apis.entities.Role;
import cm.tech.com.makeshift_reddits_apis.entities.User;
import cm.tech.com.makeshift_reddits_apis.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("makeshift-Reddit/")
public class UserController {

    final UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;


    @PostMapping("create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User save = userService.createUser(user);
        return ResponseEntity.ok(save);
    }
    @PostMapping("role/create")
    public ResponseEntity<Role> createRole(@RequestBody Role role) {
        Role save = userService.createRole(role);
        return ResponseEntity.ok(save);
    }

    @PostMapping("login")
    public ResponseEntity<String> authenticateUser(@RequestBody User user) {
        try {
            Authentication authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return new ResponseEntity<>("User login successful!...", HttpStatus.OK);
        } catch (AuthenticationException e) {
            return new ResponseEntity<>("Authentication failed: " + e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("user/{user_id}/upvotePost/{post_id}")
    public ResponseEntity<String> userUpVotePost(@PathVariable("user_id") Long userId, @PathVariable("post_id") Long postId) {
        userService.upVotePost(userId, postId);
        return ResponseEntity.ok("Post upvoted successfully");
    }

    @PostMapping("user/{user_id}/downvotePost/{post_id}")
    public ResponseEntity<String> userDownVotePost(@PathVariable("user_id") Long userId, @PathVariable("post_id") Long postId) {
        userService.downVotePost(userId, postId);
        return ResponseEntity.ok("Post downvoted successfully");
    }
    @PostMapping("user/{user_id}/addCommentToPost/{post_id}")
    public ResponseEntity<String> addCommentToPost( @PathVariable("user_id") Long userId, @PathVariable("post_id") Long postId,
            @RequestBody String content) {
        try {
            userService.userAddCommentPost(userId, postId, content);
            return ResponseEntity.ok("Comment added successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to add comment: " + e.getMessage());
        }
    }

    @GetMapping("user/read/{id}")
    public ResponseEntity<User> read(@PathVariable Long  id) {
        User read = userService.getUserById(id);
        return ResponseEntity.ok(read);
    }

    @PostMapping("user/{user_id}/upVotecomments/{post_id}/{comment_id}")
    public ResponseEntity<String> upVotecomments( @PathVariable("user_id") Long user_id, @PathVariable("post_id") Long post_id,
                                                     @PathVariable("comment_id") Long comment_id) {
        try {
            userService.upVoteComment(user_id, post_id, comment_id);
            return ResponseEntity.ok("Comment upVoted.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to upVoted comment: " + e.getMessage());
        }
    }
    @PostMapping("user/{user_id}/downVoteComment/{post_id}/{comment_id}")
    public ResponseEntity<String> downVoteComment( @PathVariable("user_id") Long user_id, @PathVariable("post_id") Long post_id,
                                                     @PathVariable("comment_id") Long comment_id) {
        try {
            userService.downVoteComment(user_id, post_id, comment_id);
            return ResponseEntity.ok("Comment downVoted.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to downVote comment: " + e.getMessage());
        }
    }

}
