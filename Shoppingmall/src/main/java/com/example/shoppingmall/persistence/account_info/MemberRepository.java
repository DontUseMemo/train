package com.example.shoppingmall.persistence.account_info;

import com.example.shoppingmall.model.account_info.Member;
import org.springframework.data.repository.CrudRepository;

//MemberRopository는 CrudRepository를 상속받아 기능을 온전히 씀
//CrudRepository : DB에 기본적인 SQL문을 통해 소통 (INSERT INTO, SELECT, UPDATE, DELETE)
public interface MemberRepository extends CrudRepository<Member, Long> {
}
