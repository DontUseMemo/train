package com.example.shoppingmall.model.account_info;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

//데이터 베이스에 null값이 들어갔던 이유 : 생성자를 만들지 않아서
//@AllArgsConstructor : 모든 매개변수를 갖는 생성자
//@NaArgsConstructor : 매개변수 없는 생성자
//@Builder
//혹은 @Setter를 추가

//@Entity JPA 이 객체를 기준으로 table을 만들어야 한다고 선언
@Setter
@Getter
@ToString
@Entity
public class Member {

    //SELET [*컬럼명 = 객체의 필드] FROM TABLE_NAME * 객체;
    //CREATE TABLE (
    //     seq NUMBER primary key,
    //     id  VARCHAR2(30) NOT NULL
    //      )
    //table을 만들 때, 테이블의 튜플(row)를 식별할 수 있는 기본키
    @Id
    @GeneratedValue
    private Long seq;

    @Column(length = 30, nullable = false)
    private String id;

    @Column(length = 30, nullable = false)
    private String password;

    private String email;

    @Temporal(TemporalType.DATE)
    private Date createDate;

    @Temporal(TemporalType.DATE)
    private Date updateDate;
}
