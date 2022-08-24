package com.example.shoppingmall.repository.board_info;

import com.example.shoppingmall.entity.board_info.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentsRepository extends JpaRepository<Comments, Long> {

    @Query(value = "SELECT c FROM Comments c JOIN FETCH c.board WHERE c.board.seq = :input_board_seq")
    List<Comments> findCommentsByBoardSeq(Long input_board_seq);
}
