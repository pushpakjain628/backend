package com.backend.project.service;

import com.backend.project.model.Comments;
import com.backend.project.model.Post;
import com.backend.project.repository.ICommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private ICommentRepository repository;

    @Autowired
    private PostService postService;

    public Comments saveComment(Comments comments, int postId) {
        Post post = postService.findPostById(postId);
        comments.setPost(post);
        return  repository.save(comments);
    }

    public List<Comments> findAllComments() {
        return repository.findAll();
    }
}
