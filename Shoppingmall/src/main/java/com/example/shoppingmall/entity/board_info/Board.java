package com.example.shoppingmall.entity.board_info;


import com.example.shoppingmall.entity.account_info.Member;
import com.example.shoppingmall.entity.base.BaseTimeEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//entity: 이 class가 JPA를 통해 데이터베이스 테이블로 쓰겠다고 명시해주는 속성
@Getter
@ToString
@Entity
@Setter
public class Board extends BaseTimeEntity {

    //@Id : PK (primary key) SQL문의 기본키
    //@GeneratedValue 자동생성 속성

    //영속화
    //IDENTITY : DB에 필드값을 저장 후에 기본키를 생성함
    //AUTO_INCREMENT처럼 DB에 값을 저장하고 나서야 기본키를 구할 수 있을 때 쓰임
    //= DB에 클라이언트에서 받은 정보를 저장 후에 기본키(ex/seq)를 부여
    //Entity가 영속상태가 되기 위해서는 식별자가 필수
    //em : EntityManager
    //em.persistence()룰 하는 즉시 insert SQL이 DB에 전달
    //필드값을 테이블에 저장함과 동시에 기본키 생성해서 집어넣는다.
    //트랜잭션이 지원하는 쓰기 지연이 동작 x

    //Sequence : DB(Oracle) Sequence 함수 기능을 활용하여 생성
    //DB마다 index를 생성하고 관리하는 함수가 있음(DB에서 관리)
    //시퀀스 전략은 em.persist()를 호출할 때 먼저 DB 시퀀스를 사용해서 식별자를 조회
    //이후 트랜잭션 커밋 시점에 플러시가 발생하면 엔티티를 DB에 저장

    //Sequence 최적화 전략
    //allocationSize 시퀀스 접근하는 횟수를 줄이기 위한 바업ㅂ.
    //예를 들어, allocationSize가 50이라면, 시퀀스 함수 한 번 조회시
    //50씩 증가하고, 1~50사이에서는 메모리에서 식별자를 할당,
    //백엔드(서버)마다 DB를 조회해서 여러 서버가 동시에 접근하고 시퀀스 함수를 사용하며 시쿠너스르 ㄹ할당할 때 1단위로 size가 증가하면 DB저장에 문제를
    //야기할 수 있으므로 size를 넓게 잡아 ㅔ모리가 알아서 접속한 서버마다 할당해주는 전략
    //~50으로 시퀀스 값을 선점하므로 여러 JVM(Spring boot서버)가 동시에
    //동작해도 기본키값이 충돌하지 않는 장점, 부하를 피할 수 있다.

    //Table : Seq(시퀀스) 정보를 갖고 있는 테이블을 만들고, seq컬럼값을 저장 뒤에 불러온다.
    //Table은 여타 위에 전략과 달리 임의의 seq table을 만들기 때문에 table 성능이 좋지 않을 경우 (튜닝x)
    //속도적인 문제를 야기할 수 있다

    //allocationSize 시퀀스 접근하는 횟수를 줄이기 위한 방편편
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    //코멘트와 양방향 관계 적용
    //게시글이 삭제되면 댓글도 삭제되도록 cascade 적용
    @OneToMany(mappedBy = "board")
    private List<Comments> commentsList = new ArrayList<>();

    //deleteYn
}
