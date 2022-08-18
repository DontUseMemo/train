package com.example.shoppingmall.Service.account_info;

import com.example.shoppingmall.entity.account_info.Member;
import com.example.shoppingmall.repository.account_info.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService{

    //MemberRepository라는 객체를 선언
    //필드 주입방식은 @Autowired를 통해 컨테이너에서 주입당함 (할당)
    //final은 변하지 않는 한 개 : MemberServiceImpl는 안심하고 MemberRepository를 사용용
   private final MemberRepository memberRepo;

    //생성자 주입방식은 아래 생성자에 @Autowired를 붙여서 컨테이너에서 주입 당함
    //MemberServiceImpl 클래스의 생성자를 선언
    //매개변수를 MemberRepository로 받아서 위에 있는 필드값 MemberService에 할당
    //장점 : 객체 생성 시점에서 생성자를 통해서 주입받기 때문에 순서가 명확해짐
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
    public List<Member> getMembersContainKeyword(String keyword) {
        List<Member> memberList = memberRepo.findMembersByEmail(keyword);
        for (Member member : memberList) {
            member.setEmail(member.getEmail().substring(0,3) + "****");
        }
        return memberList;
    }

    @Override
    public Member CheckMemberWithIdAndPassword(Member member) {
        Member checkmember = memberRepo.findMemberBySeq(member.getSeq());
        if (checkmember.getId().equals(member.getId())) {
            if (checkmember.getPassword().equals(member.getPassword())) {
                return checkmember;
            }
            else {
                return null;
            }
        } else {
            return null;
        }
    }

}
