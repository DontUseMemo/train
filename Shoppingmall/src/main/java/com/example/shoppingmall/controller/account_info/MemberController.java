package com.example.shoppingmall.controller.account_info;

import com.example.shoppingmall.Service.account_info.MemberService;
import com.example.shoppingmall.model.account_info.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

//디스패처 서블릿이 컨트롤러를 찾기 위해서 @Controller라고 선언
@Controller
public class MemberController {
    @Autowired
    private MemberService memberService;

    //return 타입이 String 이유 : HTML 파일명을 찾기 위해
    @GetMapping("account/insertAccount")
    public String insertAccountView() {
        return "account/insertAccount";
    }

    @PostMapping("account/insertAccount")
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
}
