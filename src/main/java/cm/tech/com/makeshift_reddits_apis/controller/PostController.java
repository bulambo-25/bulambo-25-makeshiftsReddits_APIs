package cm.tech.com.makeshift_reddits_apis.controller;


import cm.tech.com.makeshift_reddits_apis.entities.Post;
import cm.tech.com.makeshift_reddits_apis.entities.dto.PostDTO;
import cm.tech.com.makeshift_reddits_apis.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("makeshift-Reddit/post/")
public class PostController {

    final PostService postService;

    @PostMapping("create")
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        Post save = postService.createPost(post);
        return ResponseEntity.ok(save);
    }

    @PostMapping("update")
    public ResponseEntity<Post> UpdatingPost(@RequestBody Post post) {
        Post save = postService.updatePost(post);
        return ResponseEntity.ok(save);
    }
        @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deletePostById(@PathVariable Long id) {
        this.postService.deletePostById(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("getAllPost/upvoted/{id}")
    public ResponseEntity<List<Post>> getAllPostUpvotedById(@PathVariable Long id) {
        List<Post> posts = postService.findAllUpvotedByUser(id);
        return ResponseEntity.ok(posts);
    }
    @GetMapping("getAllPost/downvoters/{id}")
    public ResponseEntity<List<Post>> getAllPostDownVotersById(@PathVariable Long id) {
        List<Post> posts = postService.findAllDownVotersByUser(id);
        return ResponseEntity.ok(posts);
    }
    @GetMapping("getAllPost/username/{username}")
    public ResponseEntity<List<Post>> getAllPostDownVotersById(@PathVariable String  username) {
        List<Post> posts = postService.findAllByUserUsername(username);
        return ResponseEntity.ok(posts);
    }
    @GetMapping("view/all")
    public ResponseEntity<List<PostDTO>> getAllPosts() {
        List<PostDTO> posts = postService.viewAllPostsWithCommentsAndVoteCounts();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }
    @GetMapping("getAllPost/user/{id}")
    public ResponseEntity<List<Post>> getAllUsers(@PathVariable Long id) {
        List<Post> posts = postService.findPostsByUser(id);
        return ResponseEntity.ok(posts);
    }


}
