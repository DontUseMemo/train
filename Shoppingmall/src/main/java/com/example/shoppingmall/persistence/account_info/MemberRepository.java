package com.example.shoppingmall.persistence.account_info;

import com.example.shoppingmall.model.account_info.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

//MemberRopository는 CrudRepository를 상속받아 기능을 온전히 씀
//CrudRepository : DB에 기본적인 SQL문을 통해 소통 (INSERT INTO, SELECT, UPDATE, DELETE)
public interface MemberRepository extends CrudRepository<Member, Long> {

//    List<Member> findByIdOrSeq(Long seq);

    //Return 내용선언, Find-변수명에 맞춰서 메서드 생성, 필요한 매개변수
    List<Member> findMembersBySeqOrId(String seq, String Id);

    //(ID는 중복가능한 구조에서) Id값을 매개변수로 넣고, 아이디 생성날짜가 가장 최신인 것
    Member findFirstById(String Id);
}
