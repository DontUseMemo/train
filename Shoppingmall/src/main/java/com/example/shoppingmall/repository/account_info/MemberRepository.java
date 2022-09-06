package com.example.shoppingmall.repository.account_info;

import com.example.shoppingmall.entity.account_info.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

//MemberRopository는 CrudRepository를 상속받아 기능을 온전히 씀
//CrudRepository : DB에 기본적인 SQL문을 통해 소통 (INSERT INTO, SELECT, UPDATE, DELETE)
public interface MemberRepository extends JpaRepository<Member, Long> {

//    List<Member> findByIdOrEmail(String id, String email);

    //Return 내용선언, Find-변수명에 맞춰서 메서드 생성, 필요한 매개변수
//    List<Member> findMembersEmailOrId(String email, String id);

    //(ID는 중복가능한 구조에서) Id값을 매개변수로 넣고, 아이디 생성날짜가 가장 최신인 것
//    Member findFirstById(String Id);

    @Query(value = "select m from Member m where m.email = :email_1 or m.id = :id_1")
    Member findMemberByEmailOrId(String email_1, String id_1);

    Member findMemberById(String id);

    @Query(value = "select m from Member m where m.id = :id_1 order by m.createDate DESC")
    Member findFirstBy(String id_1);

    //반환을 Object배열로 반환해서 문제가 발생
    @Query(value = "select m from Member m where m.email like %:keyword%")
    List<Member> findMembersByEmail(String keyword);

    @Query(value = "select m from Member m where m.seq = :seq")
    Member findMemberBySeq(Long seq);

    @Query(value = "select * from Member", nativeQuery = true)
    List<Member> findAllMembers();
}
