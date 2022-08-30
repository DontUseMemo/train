package com.example.shoppingmall.Service.textTransfer;

public class TextTransfer {

    public String transferText3Word(String text) throws Exception {

        String wordFirst3 = text.substring(0,3);
        String wordLast = text.substring(4,text.length());
        //substring과 split 구조 차이
        //substring : 원본 배열을 참조해서 순번과 길이만 가지고 자름 (객체를 따로 생성해서 관리)
        //String이라는 클래스 자체가 char(문자1개)를 여러개 붙여놓은 문자배열이므로
        //해당 String클래스의 값은 위와 같음 (원본 String문자열을 참조하여 반환)

        //split : 새로운 인스턴스를 만들어서 문자열을 자르고, 더불어 결과값을 String 배열로 받아옴
        //split 함수는 String문자열을 끊어서 새로운 배열에 저장

        //replaceAll 메서드의 변경할 값에 "."을 쓰면 모든 문자를 치환
        wordLast = wordLast.replace(".", "*");

        return wordLast;
    }
}
