package com.example.shoppingmall.controller.account_info;

import com.example.shoppingmall.Service.account_info.MemberService;
import com.example.shoppingmall.entity.account_info.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

//디스패처 서블릿이 컨트롤러를 찾기 위해서 @Controller라고 선언
@Controller
@RequestMapping(path="/account")
public class MemberController {
    @Autowired
    private MemberService memberService;

    //(클라이언트가 두 분류)게시판 : 사용자관점,
    //시스템관리관점(회원관리, 게시판관리, 컨텐츠관리) [웹솔루션을 관리하는 오너]
    //getAccountList : 전체 회원 목록 보기 : 웹솔루션에서 웹시스템을 관리하는 관리자를 위한 기능
    //public : 전부공개
    //String : 이 메서드가 실행 완료되면 최종적으로 리턴하는 타입 (HTML 파일명을 찾기 위해)
    @GetMapping("/getAccountList")
    public String getAccountList(Model model) {
        //model : 컨트롤러에서 작업한 결과물을 HTML에 전달하기 위한 매개체
        //addAttribute : key/value 로 데이터를 저장하는 메서드
        //attributeName(key) : 뒤에 있는 value를 호출하기 위한 문자열(key)
        //memberService.getMemberList() : @Autowired로 선언된 MemberService 클래스를 호출하여
        //getMemberList()메서드 실행
        List<Member> accountList = memberService.getMemberList();
        model.addAttribute("accountList",accountList);
        return "/account/getAccountList";
    }

    //member : 클라이언트에서 서버로 데이터를 받는 Entity
    //model : 서버에서 클라이언트로 데이터를 전송하는 매개체
    @GetMapping("/getAccount")
    public String getAccount(Model model, Member member) {
        model.addAttribute("member",memberService.getMember(member));
        return "/account/getAccount";
    }

    //deleteAccount : 회원정보 삭제
    @GetMapping("/deleteAccount")
    public String deleteAccount(Member member) {
        memberService.deleteMember(member);
        return "redirect:/account/getAccountList";
    }

    //updateAccount : 회원정보 수정
    @PostMapping("/updateAccount")
    public String updateAccount(Member member) {
        memberService.updateMember(member);
        return "redirect:/account/getAccountList";
    }

    //기존 데이터의 무결성 체크를 위한 데이터 전체 조회와 일부 수정 작업
    //+백업 entity
    //회원정보가 일정 수치까지 다다르면(혹은 이벤트가 발생) updateAccountAll이라는 메서드를 통해
    //기존 entity의 테이블의 정보를 모두 백업 entity에 저장
    //crudRepository를 보면 인터페이스 메서드 findAll 회원정보 모두 불러온 뒤에 SaveAll메서드로 저장

    //+회원정보 1개의 테이블에서 관리하지 않음 > 1년 지난 회원(로그인을 안 한 장기 휴식회원)
    //+1년 미접속 계정은 따로 테이블에 옮겨서 저장(예전 스타일)
    //날짜별로 1년이 지나면 새로 테이블을 생성해서 회원을 관리한다.(회원가입한 날짜) >
    // > 최신회원들을 관리하는 마케팅부서에게 도움
    // > DB 백업할 때 테이블 파편화로 트랜잭션 위험 또는 시간 절약
    // > 단점 : Admin(관리자)는 모든 회원정보를 볼 때 다수의 테이블을 동시에 봐야 하기 때문에 JOIN을 써서
    //속도가 느림

    //return 타입이 String 이유 : HTML 파일명을 찾기 위해
    @GetMapping("/insertAccount")
    public String insertAccountView() {
        return "account/insertAccount";
    }

    //Member 라는 매개변수로 Controller에 전달
    //Member(Entity)이고 DTO(Data Transfer Object)
    //어디선가 받거나 만든 데이터를 객체로 만드는 것 : DTO
    @PostMapping("/insertAccount")
    public String insertAccountView(Member member) {
        //클라이언트에서 ID/PW
        //createDate
        //updateDate
        System.out.println(member.toString());
        member.setCreateDate(new Date());
        member.setUpdateDate(new Date());
        memberService.insertMember(member);
        return "Index";
    }

    @GetMapping("/selectAccount")
    public String selectAccount() { return "/account/selectAccount"; }

    @PostMapping("/selectAccount")
    public String resultAccount(String keyword, Model model) {
        model.addAttribute("memberList",
                memberService.getMembersContainKeyword(keyword));
        return "/account/resultAccount";
    }
}
