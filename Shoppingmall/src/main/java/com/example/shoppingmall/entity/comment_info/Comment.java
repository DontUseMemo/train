package com.example.shoppingmall.entity.comment_info;

import com.example.shoppingmall.entity.Board;
import com.example.shoppingmall.entity.account_info.Member;
import com.example.shoppingmall.entity.base.BaseTimeEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Getter
@Setter
@Entity
public class Comment extends BaseTimeEntity {

    @Id @GeneratedValue
    private Long seq;

    @ManyToOne
    @JoinColumn(name = "seq", referencedColumnName = "seq")
    private Board board;

    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    @Column(nullable = false, updatable = false)
    private Member member;

    private String content;
}
