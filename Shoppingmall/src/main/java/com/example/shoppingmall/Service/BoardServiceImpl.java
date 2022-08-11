package com.example.shoppingmall.Service;

import com.example.shoppingmall.model.Board;
import com.example.shoppingmall.persistence.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//JPA가 @Service로 선언된 클래스를 갖고 JDBC에게 기능적인 구현을 위한 속성
@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardRepository boardRepo;
    //BoardRepository에 있는 db와 연동하여 기능하는 것을 명시

    public BoardServiceImpl() {}

    public List<Board> getBoardList() { return (List)this.boardRepo.findAll(); }

    @Override
    public List<Board> getBoardList(Board board) {
        return null;
    }

    public void insertBoard(Board board) {this.boardRepo.save(board);}

    public Board getBoard(Board board) {return (Board)this.boardRepo.findById(board.getSeq()).get();}

    public void updateBoard(Board board) {
        Board findBoard = (Board)this.boardRepo.findById(board.getCnt()).get();
        findBoard.setTitle(board.getContent());
        findBoard.setContent(board.getContent());
        this.boardRepo.save(findBoard);
    }

    public void deleteBoard(Board board) {this.boardRepo.deleteById(board.getSeq());}
}
