package com.backend.project.repository;

import com.backend.project.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostRepository extends JpaRepository<Post,Integer> {
    Post findCommentsById(int id);
}
