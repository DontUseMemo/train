package com.example.shoppingmall.controller.account_info;

import com.example.shoppingmall.Service.account_info.MemberService;
import com.example.shoppingmall.entity.account_info.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

//디스패처 서블릿이 컨트롤러를 찾기 위해서 @Controller라고 선언
@Controller
@RequestMapping(path="/account")
public class MemberController {

    //MemberController 클래스가 실행되면 MemberService를 불러와서 주입 당하는 것
    //@Autowired를 사용해서 MemberController는 MemberService를 주입당하겠다고 선언
    //Springboot는 인식 함 : MemberController가 실행되려면 MemberService가 필요함
    //장점1 : MemberController 실행되는 시점에서 필요한 객체만 실행할 수 있는 절약성
    //장점2 : 이미 컨테이너에 있는 객체를 활용하여 최대한 인스턴스(객체)를 최소한으로 사용
    //아래 @Autowired는 필드 주입 방식
    //메서드, 생성자, 필드 (객체의 데이터)
    //필드 주입의 경우에는 2개 이상 주입할 시 어떤 게 먼저 주입당하는지 모름
    //주입당하는 A와 B가 서로 주입당할 경우에는 어떤 게 먼저 생성할지 모르는 문제
    //@Setter를 통해 의존성을 주입
    //주입받으려는 빈의 생성자를 호출하고 없을 경우 컨테이너에 등록하고 객체의 수정자를 호출하여 주입. Final 쓸 수 없음
    //생성 시점 이후에 setter를 통해 주입할 수 있으므로 결합도가 낮으나,
    //언제나 수정할 수 있다는 문제와 함께 주입하는 bean의 기능을 쓸 때 주입당하지 않았다면 에러가 생기는 문제
    @Autowired
    private MemberService memberService;

    //일반 자바라면, 실행하는 클래스 (main) 안에서 인스턴스를 만들어서 인스턴스 안에 있는 메서드를 실행 (Static : 불러옴)
    //실행되는 클래스(main)이 먼저 존재하고 인스턴스로 후에 생성

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
//        member.setCreateDate(new Date());
//        member.setUpdateDate(new Date());
        memberService.insertMember(member);
        return "Index";
    }

    @GetMapping("/selectAccount")
    public String selectAccount() { return "/account/selectAccount"; }

    @PostMapping("/selectAccount")
    public String resultAccount(@RequestParam("keyword") String keyword,
                                Model model) {
        model.addAttribute("memberList",
                memberService.getMembersContainKeywordUseSecurity(keyword));
        return "/account/resultAccount";
    }

    @GetMapping("/findEmail")
    public String findEmail(Member member, Model model) {
        model.addAttribute("seq", member.getSeq());
        return "/account/findEmail"; }

    @PostMapping("/findEmail")
    public String findEmailResult(Member member, Model model) {
        Member checkingMember = memberService.findEmailByIdAndPassword(member);
        if (checkingMember != null) {
            model.addAttribute("memberList",checkingMember);
        } else {
            model.addAttribute("msg", "잘못된 아이디나 패스워드입니다.");
        }
        return "/account/resultAccount";
    }
}
