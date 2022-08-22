package com.example.shoppingmall.entity;


import com.example.shoppingmall.entity.account_info.Member;
import com.example.shoppingmall.entity.base.BaseTimeEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Date;

//entity: 이 class가 JPA를 통해 데이터베이스 테이블로 쓰겠다고 명시해주는 속성
@Getter
@ToString
@Entity
@Setter
public class Board extends BaseTimeEntity {

    //@Id : PK (primary key) SQL문의 기본키
    //@GeneratedValue 자동생성 속성
    @Id @GeneratedValue
    private Long seq;

    //@Column은 title 필드값을 컬럼화할 때 길이와 null 입력 가능여부 옵션
    @Column(length = 40, nullable = false)
    private String title;

    @Column(nullable = false, updatable = false)
    private String writer;

    //@ColumnDefault 생성할 때 기본 데이터
    @Column(nullable = false)
    @ColumnDefault("'no content'")
    private String content;

    //@ManyToOne 다양한 board는 1개의 member를 바라본다
    //member를 필드에 선언
    //참조키가 어디인지 선언(member기본키가 board의 참조키로 기본적으로 할당)
    //board의 writer는 member의 id와 연관되어 있고, 참조키로 id로 연결되어 있다.
    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Member member;

    //타입이 날짜
//    @Temporal(TemporalType.DATE)
//    private Date createDate;

    @ColumnDefault("0")
    @Column(insertable = false, updatable = false)
    private Long cnt;

    //deleteYn
}
