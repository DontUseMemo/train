package com.example.shoppingmall.Service.account_info;

import com.example.shoppingmall.entity.account_info.Member;
import com.example.shoppingmall.repository.account_info.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepo;

    @Autowired
    protected MemberServiceImpl(MemberRepository memberRepo) {this.memberRepo = memberRepo;}

    @Override
    public Member getMemberWhereIdOrEmail(String Email, String Id) {
        return memberRepo.findMemberByEmailOrId(Email, Id);
    }

    //모든 회원의 정보를 가져다 오는 것
    //return List<Member> : 모든 회원의 정보를 List 배열에 담아서 return
    //public : 모두 공개하는 메서드
    //List<Member> : 이 메서드가 실행되면 return되는 타입
    //(List<Member>) : 뒤에 있는 결과값을 형변환
    //memberRepo :@Autowired MemberRepository 를 통해 기능 실행
    //findAll() : MemberRepo에 있는 모든 정보 가져오기 메서드 실행
    @Override
    public List<Member> getMemberList() {
        return (List<Member>) memberRepo.findAll();
    }

    //회원 1명의 정보를 Entity에 맞춰서 DBdp 조작
    @Override
    public void insertMember(Member member) {
        memberRepo.save(member);
    }

    @Override
    public Member getMember(Member member) { return memberRepo.findById(member.getSeq()).get(); }

    @Override
    public void updateMember(Member member) {
        //1. seq를 통해서 튜플 정보를 모두 가져오기
        //2. 가져온 튜플 정보중 수정할 내용 적용
        //3. DB에 저장(덮어쓰기)
        //findById().get() : 고유키 기준으로 튜플 전체 데이터 가져오기
        Member findMember = memberRepo.findById(member.getSeq()).get();
        //튜플 전체 내용 중에 ID 주소 수정 (Setter)
        findMember.setId(member.getId());
        findMember.setEmail(member.getEmail());
        //crudRepo의 save 메서드를 통해 데이터 저장
        memberRepo.save(findMember);

        //고유키
        //1. 다른 튜플을 식별할 수 있는 값 (데이터 한 줄) : DB관점에서 보는 것
        //2. 다른 테이브르이 튜플과 연동하기 위한 값 (JOIN, 외래키)
        //3. 객체지향 방법으로 DB를 저장
        //3-1. 영속성 : DB에 영구저장
        //3-2. ACID 중 고립성 : 다른 트랜잭션 작업에 연관되지 않도록 해주는 것
        //3-2. : 관리자1은 seq 10의 회원정보를 바꿨습니다. 이미 접속해 있던 관리자2가 seq10 회원의 정보를 조회합니다.
        //seq10의 회원정보를 바꾸는 작업이 한 개의 트랜잭션. 관리자2의 seq10회원의 정보를 조회하고 수정하는 작업도 한 개의 트랜잭션.
        //관리자1의 트랜잭션 작업이 완료될 때까지 관리자2의 seq10회원정보는 옛날 정보를 조회하고 있고,
        //관리자1의 트랜잭션 작업이 완료되는 순간까지 관리자2는 seq10회원정보를 수정할 수 없다.
        //다른 필드값은 수정이 가능해도, seq는 튜플의 식별자로써 수정이 불가해야, 관리자1, 2의 트랜잭션 작업을 스프링부트에서 구분할 수 있다.
    }

    @Override
    public void deleteMember(Member member) { memberRepo.deleteById(member.getSeq()); }

    @Override
    @Transactional
    public List<Member> getMembersContainKeyword(String keyword) {
        return memberRepo.findMembersByEmailContaining(keyword);
    }
}
