package com.example.shoppingmall;

import com.example.shoppingmall.Service.BoardServiceImpl;
import com.example.shoppingmall.Service.weatherAPI.WeatherTest;
import com.example.shoppingmall.entity.account_info.Member;
import com.example.shoppingmall.entity.board_info.Board;
import com.example.shoppingmall.repository.account_info.MemberRepository;
import com.example.shoppingmall.Service.webScraping.Selenium;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ShoppingmallApplicationTests {

    @Autowired
    Selenium selenium;
    @Autowired
    WeatherTest weatherTest;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    BoardServiceImpl boardService;

    @Test
    void apiTesting() {
        weatherTest.resultAPI();
    }

    @Test
    @DisplayName("멤버 가입데이터 저장과 데이터가 잘 들어갔는지 확인")
    void contextSave() {
        //Setter로 엔티티를 생성하고 repository가 정상 작동하는지 확인
        Member member = new Member();
        //클라이언트에서 controller에 데이터를 전달하는 내용을 setter를 통해 대체
        member.setId("ccc");
        member.setPassword("ccc");
        member.setEmail("ccc@naver.com");
        System.out.println(member);
        memberRepository.save(member);
    }

    @Test
    void Scraping() {
        selenium.scraping();
    }
    @Test
    void contextLoads() {
    }

    @Test
    @DisplayName("멤버를 모두 찾아오는지 확인")
    void testFindAllMember() {
        List<Member> allMembers = memberRepository.findAllMembers();
        for (Member member : allMembers) {
            System.out.println(member.getId());
        }
    }

    @Test
    @DisplayName("이메일로 멤버를 찾아오는지 확인")
    void testFindMemberByEmail() {
        List<Member> members = memberRepository.findMembersByEmail("dd");
        for (Member member : members) {
            System.out.println(member.getEmail());
        }
    }

    @Test
    @DisplayName("특정 회원을 검색한 뒤 검색된 회원이 작성한 모든 게시물을 불러오는 기능")
    void testFindMemberById() {
        //MemberRepository에 'dd'라는 회원이 있는 검색한다.
        Member member = memberRepository.findMemberById("dd");

        //MemberRepository에 조회된 멤버가 작성한 BoardRepository의 모든 게시글 조회
        List<Board> boardList = boardService.getEveryBoardByMemberId(member);
        for (Board board : boardList) {
            System.out.println(board.getTitle());
        }
    }
}
