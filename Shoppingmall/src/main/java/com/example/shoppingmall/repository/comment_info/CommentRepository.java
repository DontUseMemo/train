package com.example.shoppingmall.repository.comment_info;

import com.example.shoppingmall.entity.comment_info.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
