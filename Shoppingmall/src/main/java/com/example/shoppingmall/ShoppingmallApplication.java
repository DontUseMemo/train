package com.example.shoppingmall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//@EnableJpaAuditing
//Entity의 @CreateDate, @LastModifiedDate를 자동으로 Date값을 주입함
//왜 이걸 씁니까?
//Date를 주입하거나 설정하는 부분이 3가지 존재
//1. 클라이언트에서 : 사용자가 임의로 날짜를 수정할 수 있는 위험/ 이미 클라이언트에서 Date정보를 전달받으면 쉽게 Entity에 데이터 입력가능
//2. 서버에서 : 클라이언트가 접속하는 서버의 잘짜 기준으로 일관성 있음/ 서버에서 날짜 내장메서드를 실행하는 리소스 문제
//3. DB에서 : DB는 모든 정보를 총괄하는 1개 뿐인 서버/ 모든 백엔드에서 접속하기 때문에 리소스 문제 야기
@EnableJpaAuditing
@SpringBootApplication
public class ShoppingmallApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingmallApplication.class, args);
    }

}
