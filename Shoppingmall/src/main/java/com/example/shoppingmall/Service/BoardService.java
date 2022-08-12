package com.example.shoppingmall.Service;

import com.example.shoppingmall.model.Board;

import java.util.List;

public interface BoardService {
    List<Board> getBoardList();
    void insertBoard(Board board);
    Board getBoard(Board board);
    void updateBoard(Board board);
    void deleteBoard(Board board);
}
