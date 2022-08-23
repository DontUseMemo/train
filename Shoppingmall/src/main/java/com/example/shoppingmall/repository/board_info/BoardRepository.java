package com.example.shoppingmall.repository.board_info;

import com.example.shoppingmall.entity.Board;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

//CrudRepository를 상속받음
//CrudRepository : Entity를 매개체로 create, read, update, delete 기능을 하는 인터페이스
//CrudRepository<Board, Long>의 매개변수 Board(Entity)와 Long(PK기본키의 타입)을 선언
//JPA가 어떤 객체로 어던 타입으로 찾아야하는지 알아들음
public interface BoardRepository extends CrudRepository<Board, Long> {

    //튜닝 : join과 where절의 순서를 정함으로써 select속도 튜닝을 어떻게 할지 전략적 구성 1>2>[3>4]
    //Member의 튜플이 무척 많을 경우 where절을 통해 Id검색 이후 Board와 Join하는 것이 DB검색 속도에 유리
    //회원 id를 겁색하면 (writer와 id가 동일) 관련된 writer의 게시글 모두 출력받아 리턴
    //inner join : ANSI QUERY <> ORACLE QUERY와 다름
    //board의 튜플을 가져와야 하기 때문에 from Board(Board 테이블이 기준)
    //select b from Baord b //board테이블의 튜플을 검색하겠다 (모든 컬럼) 실행순서1
    //inner join Member m // member테이블과 교집합 조인(inner join)하겠다. 2
    //On b.writer = m.id //board의 writer와 member의 id가 동일한 튜플을 검색하겠다. (b는 board의 별칭, m은 member의 별칭) 3
    //where m.id = :memberId //inner조인한 튜플들의 결과물 중에 member.id가 매개변수 memberId와 동일한 조건을 걸겠다. 4
    @Query(value = "SELECT B FROM Board B INNER JOIN Member M ON B.writer = M.id WHERE M.id = :memberId")
    List<Board> findAllByMemberIdEqualsBoardWriter(String memberId);
}
