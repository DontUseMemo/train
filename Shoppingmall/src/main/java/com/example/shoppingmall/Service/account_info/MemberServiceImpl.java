package com.example.shoppingmall.Service.account_info;

import com.example.shoppingmall.model.account_info.Member;
import com.example.shoppingmall.persistence.account_info.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService{
    @Autowired
    private MemberRepository memberRepo;

    //모든 회원의 정보를 가져다 오는 것
    //return List<Member> : 모든 회원의 정보를 List 배열에 담아서 return
    @Override
    public List<Member> getMemberList() {
        return (List<Member>) memberRepo.findAll();
    }

    //회원 1명의 정보를 Entity에 맞춰서 DBdp wjwkd
    @Override
    public void insertMember(Member member) {
        memberRepo.save(member);
    }

    @Override
    public Member getMember(Member member) {
        return null;
    }

    @Override
    public void updateMember(Member member) {

    }

    @Override
    public void deleteMember(Member member) {

    }
}
