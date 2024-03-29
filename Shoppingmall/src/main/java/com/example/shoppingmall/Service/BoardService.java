package com.example.shoppingmall.Service;

import com.example.shoppingmall.entity.board_info.Board;
import com.example.shoppingmall.entity.account_info.Member;
import com.example.shoppingmall.entity.board_info.Comments;
import com.example.shoppingmall.entity.dataSample.FileUploadEntity;

import java.util.List;

public interface BoardService {
    List<Board> getBoardList();
    Long insertBoard(Board board);
    Board getBoard(Board board);
    void updateBoard(Board board);
    void deleteBoard(Board board);
    List<Board> getEveryBoardByMemberId(Member member);
    List<Comments> getAllComments(Comments comments);
    void insertComments(Comments comments);
    Long insertFileUploadEntity(FileUploadEntity fileUploadEntity);
    FileUploadEntity getFileUploadEntity2(Long board_seq);
}
