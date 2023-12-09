package com.backend.project.repository;

import com.backend.project.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentRepository  extends JpaRepository<Comments,Integer> {
}
