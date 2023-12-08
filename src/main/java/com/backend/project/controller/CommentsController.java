package com.backend.project.controller;

import com.backend.project.model.Comments;
import com.backend.project.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentsController {


    @Autowired
    private CommentService service;


    @PostMapping("/posts/{postId}")
    public Comments createComment(@RequestBody Comments comments, @PathVariable("postId") int postId){
        return service.saveComment(comments,postId);
    }

    @GetMapping
    public List<Comments> getListOfComments(){
        return service.findAllComments();
    }

}
