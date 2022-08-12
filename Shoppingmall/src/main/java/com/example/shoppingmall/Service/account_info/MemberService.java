package com.example.shoppingmall.Service.account_info;

import com.example.shoppingmall.model.account_info.Member;

import java.util.List;

public interface MemberService {
    List<Member> getMemberList();
    void insertMember(Member member);
    Member getMember(Member member);
    void updateMember(Member member);
    void deleteMember(Member member);
}
