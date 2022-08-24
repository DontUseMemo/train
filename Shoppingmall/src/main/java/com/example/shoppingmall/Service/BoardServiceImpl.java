package com.example.shoppingmall.Service;

import com.example.shoppingmall.entity.board_info.Board;
import com.example.shoppingmall.entity.account_info.Member;
import com.example.shoppingmall.entity.board_info.Comments;
import com.example.shoppingmall.repository.board_info.BoardRepository;
import com.example.shoppingmall.repository.board_info.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//JPA가 @Service로 선언된 클래스를 갖고 JDBC에게 기능적인 구현을 위한 속성
@Service
public class BoardServiceImpl implements BoardService {

    private BoardRepository boardRepo;
    private CommentsRepository commentsRepo;

    @Autowired
    public BoardServiceImpl(BoardRepository boardRepository, CommentsRepository commentsRepository) {
        this.boardRepo = boardRepository;
        this.commentsRepo = commentsRepository;
    }

    //BoardRepository에 있는 DB와 연동하여 기능하는 것을 명시

    //클라이언트에서 받아온 Board객체의 데이터를 BoardRepository의 상속받은 CrudRepository의 findAll메서드를 통해서
    //전체 조회
    @Override
    public List<Board> getBoardList() {
        return (List<Board>) boardRepo.findAll();
    }

    //클라이언트에서 받아온 Board객체의 데이터를 BoardRepository의 상속받은 CrudRepository의 Save메서드를 통해서
    //DB에 저장 (저장하는 SQL문 만들어서 실행)
    @Override
    public void insertBoard(Board board) {
        boardRepo.save(board);
    }

    @Override
    public Board getBoard(Board board) {
        return boardRepo.findById(board.getSeq()).get();
    }

    @Override
    public void updateBoard(Board board) {
        Board findBoard = boardRepo.findById(board.getSeq()).get();
        findBoard.setTitle(board.getTitle());
        findBoard.setContent(board.getContent());
        boardRepo.save(findBoard);
    }

    @Override
    public void deleteBoard(Board board) {
        boardRepo.deleteById(board.getSeq());
    }

    @Override
    public List<Board> getEveryBoardByMemberId(Member member) {
        //repository
        return boardRepo.findAllByMemberIdEqualsBoardWriter(member.getId());
    }

    @Override
    public List<Comments> getAllComments(Comments comments) {
        return commentsRepo.findCommentsByBoardSeq(comments.getBoardSeq());
    }
}
