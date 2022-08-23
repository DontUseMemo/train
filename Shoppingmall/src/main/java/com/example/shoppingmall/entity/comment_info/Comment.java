package com.example.shoppingmall.entity.comment_info;

import com.example.shoppingmall.entity.base.BaseTimeEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@ToString
@Getter
@Setter
@Entity
public class Comment extends BaseTimeEntity {

    @Id @GeneratedValue
    private Long seq;

    private Long boardNumber;

    @Column(nullable = false, updatable = false)
    private String writer;

    private String content;
}
