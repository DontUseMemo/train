package com.example.shoppingmall.entity.board_info;

import com.example.shoppingmall.entity.base.BaseTimeEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Getter
@Setter
@Entity
public class Comments extends BaseTimeEntity {

    @Id @GeneratedValue
    private Long seq;

    @Transient
    private Long boardSeq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "boardSeq", referencedColumnName = "seq")
    private Board board;

    private String content;
}
