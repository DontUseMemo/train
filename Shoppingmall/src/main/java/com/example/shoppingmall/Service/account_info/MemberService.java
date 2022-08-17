package com.example.shoppingmall.Service.account_info;

import com.example.shoppingmall.entity.account_info.Member;

import java.util.List;

public interface MemberService {
    Member getMemberWhereIdOrEmail(String Email, String Id);
    List<Member> getMemberList();
    void insertMember(Member member);
    Member getMember(Member member);
    void updateMember(Member member);
    void deleteMember(Member member);
    List<Member> getMembersContainKeyword(String keyword);
    Member CheckMemberWithIdAndPassword(String id, String password);
}
