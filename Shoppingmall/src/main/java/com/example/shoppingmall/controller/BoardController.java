package com.example.shoppingmall.controller;

import com.example.shoppingmall.model.Board;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class BoardController {

    //step3. 사용자 생성 객체 사용
    static ArrayList<Board> board_array = new ArrayList<Board>();
    static int count = 0;

    //클라이언트에서 서버로 무언가 데이터를 전송하기 위한 Mapping (@RequestMapping)
    @RequestMapping("/insertBoard")
    public String insertBoard(Model model) {
        return "insertBoard";
    }

    /**
     * Board domain CONTROLLER
     * @param category HTML에서 받아온 데이터
     * @param title
     * @param writer
     * @param content
     * @return
     * @author 김춘수
     * @version 20220808.0.0.1
     */
    //[클라이언트]html form태그의 method속성의 값인 post를 인식하여 아래의
    //@PostMapping에 연결
    @PostMapping("/insertBoard")
    public String insertBoard(
            @RequestParam("category")String category,
            @RequestParam("title")String title,
            @RequestParam("writer")String writer,
            @RequestParam("content")String content
            ) {
        count++;
        Board board = new Board();

        board.setSeq((long)count);
        board.setCategory(category);
        board.setTitle(title);
        board.setWriter(writer);
        board.setContent(content);
        board.setCreateDate(new Date());
        board.setCnt(0L);
        board_array.add(board);

        //redirect : 페이지 전환 이동
        //redirect : getBoardList >> getBoardList 페이지로 이동
        return "redirect:getBoardList";
    }

    //@어노테이션은 메서드 혹은 클래스에 속성, 정의를 해서 스프링이나 자바에서 찾기 쉽도록 해주는 선언부
    //예) @Override 은 부모 메서드를 재정의하여 사용한다고 자바나 스프링에게 속성 명시
    //@RequestParam : [클라이언트]에서 string문자열을 [서버]에 전달하는 매개변수 선언
    //@RequestParam("title")String title에서 ("title")은 [클라이언트]의 name이라는 속성로써
    //key값을 매개변수를 전달


    //@GetMapping 또는 @PostMapping은 @RequestMapping의 자식 클래스이다
    //@RequestMapping의 기능을 모두 쓸 수 있다
    //자식클래스 어노테이션이 아닌 부모클래스 어노테이션을 쓰는 이유는 기능의 한정을 통해서
    //서버의 리소스 감소 및 보안을 위해서 이다
    @GetMapping("/getBoard")
    public String getBoard(
            @RequestParam("seq")String seq,
            @RequestParam("category")String category,
            @RequestParam("userRole")String userRole,
            @RequestParam("userId")String userId,
            @RequestParam("title")String title,
            @RequestParam("writer")String writer,
            @RequestParam("content")String content,
            @RequestParam("createDate")String createDate,
            @RequestParam("cnt")String cnt,
            Model model) {
        model.addAttribute("seq", seq);
        model.addAttribute("category",category);
        model.addAttribute("title", title);
        model.addAttribute("writer", writer);
        model.addAttribute("content", content);
        model.addAttribute("createDate", createDate);
        model.addAttribute("cnt", cnt);
        model.addAttribute("userId", userId);
        model.addAttribute("userRole", userRole);
        return "getBoard";
    }


    //@RequestMapping은 [서버]에서 디스패쳐서블릿을 통해 html의 action태그의 주소와 동일한
    //문자열을 찾는 매핑기능(연결)이 실행되고 하단에 메서드가 실행
    //return String인 이유는 뷰리졸버가 html파일을 찾기 위한 문자열을 리턴
    @RequestMapping("/getBoardList")
    public String getBoardList(Model model) {
        //List 타입으로 Board객체를 넣는 boardList변수명 선언
        // = 대입연산자로 heap메모리에 ArrayLsit타입으로 할당
        //List는 ArrayList의 부모클래스
        List<Board> boardList = new ArrayList<Board>();
        //title_array.size()로 게시판 글이 1개 이상일 경우에만 model에 데이터 입력하여
        //[클라이언트]에 전달
        if(board_array.size() > 0) {
            for (int i = 0; i < board_array.size(); i++) {
                Board board = new Board();
                board.setSeq(board_array.get(i).getSeq());
                board.setCategory(board_array.get(i).getCategory());
                board.setTitle(board_array.get(i).getTitle());
                board.setWriter(board_array.get(i).getWriter());
                if (board_array.get(i).getContent().length() >= 20) {
                    String a = board_array.get(i).getContent();
                    String preview = a.substring(0,19);
                    board.setContent(preview);
                }
                else {
                    board.setContent(board_array.get(i).getContent());
                }
                board.setCreateDate(board_array.get(i).getCreateDate());
                board.setCnt(board_array.get(i).getCnt());
                boardList.add(board);
            }
        }
        //model 객체에 boardList(arraylist)를 boardList key값으로 넣음
        //attributeName = key
        //attributeValue = value
        //model에는 참조타입만 넣을 수 있다 (addAttribute 메서드 안에 매개변수 타입으로 확인 가능)
        model.addAttribute("boardList", boardList);
        //디서패처서블릿이 뷰 리졸버를 찾아서 연결해 줍니다
        //viewResolver
        //retrun getBoardList라는 문자열로 templates에 있는 같은 이름에 html파일을 찾는다
        return "getBoardList";
    }

    @GetMapping("/deleteBoard")
    public String deleteBoard(@RequestParam("seq")String seq) {
        //seq변수 (getBoard.html에서 받아옴)로 board_array 배열에서
        //.getSeq로 같은 index로 찾아 board_array에 있는 board객체 삭제 >> 게시글 삭제
        for(int i = 0; i < board_array.size(); i++) {
            //borad_array.get(i).getSeq() : board_array의 i번째 객체를 찾아서 getSeq()메서드를 통해 seq필드값 가져오기
            //equals()메서드를 통해서 매개변수 seq값과 비교 (참조 타입이므로)
            //seq 타입은 Long입니다, 소수점있는 데이터(숫자)이므로 매개변수 seq(String)과 같은 타입이 아니므로 바교 불가
            //board_array.get(i).getSeq()의 값 Long을 String으로 변환 = Long.toString()
            if(Long.toString(board_array.get(i).getSeq()).equals(seq)) {
                System.out.println(board_array.get(i).getSeq());
                //board_array(i)번째 객체 삭제
                board_array.remove(i);
            }
        }
        return "redirect:getBoardList";
    }

    //Post 방식으로 [클라이언트]에서 [서버]로 맵핑
    //HTML에서 name속성을 가진 값을 매개변수 String seq에 할당 = @RequestParam("seq")
    //board_array배열을 순회하여 board객체의 seq필드값을 매개변수 seq와 비교하여 true값 찾기
    //setTitle과 같은 setter로 데이터 변경경
    @PostMapping("/updateBoard")
    public String updateBoard(
            @RequestParam("seq")String seq,
            @RequestParam("category")String category,
            @RequestParam("title")String title,
            @RequestParam("content")String content
            ) {
        for (int i = 0; i < board_array.size(); i++) {
            if (Long.toString(board_array.get(i).getSeq()).equals(seq)) {
                board_array.get(i).setCategory(category);
                board_array.get(i).setTitle(title);
                board_array.get(i).setContent(content);
            }
        }
        return "redirect:getBoardList";
    }
}