package com.example.shoppingmall;

import com.example.shoppingmall.Service.weatherAPI.WeatherTest;
import com.example.shoppingmall.entity.account_info.Member;
import com.example.shoppingmall.repository.account_info.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShoppingmallApplicationTests {

    @Autowired
    WeatherTest weatherTest;

    @Autowired
    MemberRepository memberRepository;

    @Test
    void apiTesting() {
        weatherTest.resultAPI();
    }

    @Test
    @DisplayName("저장, 데이터가 잘 들어갔는지 확인")
    void contextSave() {
        //Setter로 엔티티를 생성하고 repository가 정상 작동하는지 확인
        Member member = new Member();
        //클라이언트에서 controller에 데이터를 전달하는 내용을 setter를 통해 대체
        member.setId("ddd");
        member.setPassword("123");
        member.setEmail("dd1@naver.com");
        memberRepository.save(member);
    }

    @Test
    void contextLoads() {
    }

}
