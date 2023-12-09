package com.backend.project.service;

import com.backend.project.model.Post;
import com.backend.project.model.User;
import com.backend.project.repository.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    IPostRepository repository;

    @Autowired
    UserService userService;

    public Post savePost(Post post) {
        return repository.save(post);
    }

    public Post mapPostToUser(int id, int userId) {
        User user = userService.findByUserId(userId);
        Post post = repository.findById(id).get();
        post.setUser(user);
        return savePost(post);
    }

    public Post findPostById(int id){
        return repository.findById(id).get();
    }

    public Post findCommentsByPostId(int id) {
        return repository.findCommentsById(id);
    }
}
