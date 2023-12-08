package com.backend.project.controller;

import com.backend.project.model.Post;
import com.backend.project.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping
    public Post createPost(@RequestBody Post post){
        return postService.savePost(post);
    }

    @PutMapping("/{postId}/user/{userId}")
    public Post mapPostToUser(@PathVariable("postId") int id, @PathVariable("userId") int userId){
        return postService.mapPostToUser(id,userId);
    }

    @GetMapping("/{postId}/comments")
    public Post getListOfComments(@PathVariable("postId") int id){
        return postService.findCommentsByPostId(id);
    }

}
