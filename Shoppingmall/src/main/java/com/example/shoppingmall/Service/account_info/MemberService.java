package com.example.shoppingmall.Service.account_info;

import com.example.shoppingmall.entity.account_info.Member;
import org.springframework.ui.Model;

import java.util.List;

public interface MemberService {
    Member getMemberWhereIdOrEmail(String Email, String Id);
    List<Member> getMemberList();
    void insertMember(Member member);
    Member getMember(Member member);
    void updateMember(Member member);
    void deleteMember(Member member);
    List<Member> getMembersContainKeywordUseSecurity(String keyword);
    Member findEmailByIdAndPassword(Member member);

    //일부분만 검색하여 사용유저 찾기
    //결과값 : 입력받은 정보(email, id, pw)가 사실유무 확인 후 비밀번호 변경(updateMember에 password)

//    boolean isThisUserHaveEmail(Member member);
//    boolean isThisUserHaveId(Member member);
//    boolean isThisUserHavePassword(Member member);

    //민감데이터 (SHA256...)

    //작성장의 모든 게시글 출력

    //board의 작성자와 회원이 같은지 확인

    //키워드분석
    //doNouns

    //getAutoKeywordBoardList

    //email @앞의 문자열과 id가 동일할 경우

    //id와 pw가 동일할 경우

    //30일 지난 회원에게 변경 페이지 안내

    //비밀번호 변경 테이블 생성 후 변경한 기록을 남긴 뒤, 변경 내용 최신 3회 내용과 비교
    //게시글을 눌러 게시글 분석, 게시글 분석 키워드, 게시글 검색(키워드 매개변수)

    //6번 id와 pwd가 동일한 경우 자바스크립트 이용
}
