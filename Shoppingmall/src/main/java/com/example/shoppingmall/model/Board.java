package com.example.shoppingmall.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Board {
    private Long seq;
    private String category;
    private String title;
    private String writer;
    private String content;
    private Date createDate;
    private Long cnt;
    private String comment;
}
