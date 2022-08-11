package com.example.shoppingmall.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Date;

//entity: 이 class가 JPA를 통해 데이터베이스 테이블로 쓰겠다고 명시해주는 속성
@Getter
@Setter
@ToString
@Entity
public class Board {
    //@Id : pk (primary key)
    //@GeneratedValue 자동생성 속성
    @Id @GeneratedValue
    private Long seq;

    //@Column을 title 필드값을 컬럼화할 때 길이와 null 입력 가능여부 옵션
    @Column(
            nullable = false
    )
    private String category;

    @Column(
            nullable = false,
            length = 40
    )
    private String title;

    @Column(
            nullable = false,
            updatable = false
    )
    private String writer;

    //@ColumnDefault 생성할 때 기본 데이터
    @Column(
            nullable = false
    )
    private String content;
    @Temporal(TemporalType.DATE)
    private Date createDate;
    @ColumnDefault("0")
    private Long cnt;
//    private String comment;
}
