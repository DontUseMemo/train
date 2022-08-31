package com.example.shoppingmall.controller;

import com.example.shoppingmall.Service.BoardService;
import com.example.shoppingmall.entity.board_info.Board;
import com.example.shoppingmall.entity.account_info.Member;
import com.example.shoppingmall.entity.board_info.Comments;
import com.example.shoppingmall.entity.dataSample.FileUploadEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static com.google.common.io.ByteStreams.toByteArray;

@Controller
@Slf4j
public class BoardController {

    @Autowired
    private BoardService boardService;

    //BoardService의 getBoardList메서드 실행 > BoardRepository(CrudRepository).findAll()를 통해서 (JPA번역)
    //DB의 데이터 불러오기(테이블전체) (SQL)
    @GetMapping("/getBoardList")
    public String getBoardList(Model model, Board board) {
        List<Board> boardList = boardService.getBoardList();

        model.addAttribute("boardList", boardList);
        return "getBoardList";
    }

    @GetMapping("/insertBoard")
    public String insertBoardView() {
        return "insertBoard";
    }

    @PostMapping("/insertBoard")
    public String insertBoard(Board board) {
        board.setCreateDate(new Date());

        //클라이언트에서 board객체를 받아서 매개변수로 사용
        //[1]BoardService의 inserBoard메서드 실행 >
        //[2]BoardRepository(CrudRepository).save(board)를 통해서 (JPA번역)
        //DB의 저장 (SQL)
        //insertBoard라는 메서드에 board객체 인자값으로 넣기
        boardService.insertBoard(board);
        return "redirect:getBoardList";
    }

    @GetMapping("/getBoard")
    public String getBoard(Board board, Model model) {
        model.addAttribute("board", boardService.getBoard(board));
        return "getBoard";
    }

    @PostMapping ("/updateBoard")
    public String updateBoard(Board board) {
        boardService.updateBoard(board);
        return "redirect:getBoard?seq="+board.getSeq();
    }

    @GetMapping("/updateBoard")
    public String updateBoardView(Board board, Model model) {
        model.addAttribute("board", boardService.getBoard(board));
        return "insertBoard";
    }

    @PostMapping("/deleteBoard")
    public String deleteBoard(Board board) {
        boardService.deleteBoard(board);
        return "redirect:getBoardList";
    }

    @GetMapping("/selectBoard")
    public String getBoardListFromMember(Member member, Model model) {
        //board.getId()는 클라이언트에서 가져옴

        //@Service에 board를 인자값으로 넣고 메서드 실행
        model.addAttribute("boardList",boardService.getEveryBoardByMemberId(member));

        //회원이 작성한 게시글리스트 리턴(List<Board>) >> HTML에 뿌려주면 끝 (Controller에 가면 메서드가 실행돼서 다른 결과물을 리턴받기 때문)
        //어느 HTML로 가느냐? = 객체지향은 재활용성이 중요한 요인중 하나
        //HTML 중 재사용 할만한 것을 먼저 찾고, 그 후에 새로 만들기에 대해 고민
        return "getBoardList";
    }

    //boardSeq 전달하면 전체 comments를 불러오는 controller method
    @GetMapping("/getCommentsList")
    public String getCommentsList(Comments comments, Model model) {
        model.addAttribute("CommentsList",boardService.getAllComments(comments));
        return "/getCommentsList";
    }

    @PostMapping("/insertComments")
    public String insertComments(Comments comments) {
        boardService.insertComments(comments);
        return "redirect:/getCommentsList";
    }

    //*client에서 server로 이미지파일 전송(데이터전송)
    //html form태그에 upload버튼으로 이미지 데이터 전송(MultipartFile) > Entity 기준으로 데이터 정보를 전달
    //-server는 이미지파일을 특정 폴더에 저장
    //장점 : 서버에 이미지 파일을 저장하므로 필요할 때 서버에서 바로 전달받을 수 있음 = db에 부담감이 줄어듬
    //단점 : 다수의 서버에 이미지 파일을 저장할 경우, 동일한 이미지 처리에 대한 이슈 발생 = UUID를 통해 이미지 이름을 구분
    //-server는 이미지 파일을 byte코드로 db에 저장
    //장점 : 이미지 데이터를 한 곳에 저장하고 관리
    //단점 : db에 많은 부하가 걸림, 데이터 저장 포멧의 한계 (oracle 기준으로 Blob 단위로 저장할 때 4gb한계에 이슈)
    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("uploadfile")MultipartFile[] uploadfile) throws IOException {
        //multipartfile을 클라이언트에서 서버로 RequestParam데이터 받아옴 name = uploadfile

        //@Slf4j Lombook라이브러리로 log데이터 찍음
        //info / error / debug 단위가 있고 단위마다 필터링하여 정보를 수집하고 관리 가능
        log.info("img load session");
        //multipartfile 데이터를 수집하여 entity FileUploadEntity에 데이터 저장
        List<FileUploadEntity> list = new ArrayList<>();
        for (MultipartFile file : uploadfile) {
            //MultipartFile이 있을 때까지 작업 진행
            if (!file.isEmpty()) {
                //MultipartFile의 정보를 dto에 저장
                FileUploadEntity dto = new FileUploadEntity(null,
                        UUID.randomUUID().toString(),
                        file.getContentType(),
                        file.getName(),
                        file.getOriginalFilename());
                list.add(dto);
                File newfileName = new File(dto.getUuid() + "_" + dto.getName() + ".PNG");
                //file을 서버에 저장하는 스트림행위는 서버가 성공할지 여부를 체크하므로 exception처리 필요
                //메서드에 throws IOException 처리 = try catch처리 필요
                file.transferTo(newfileName);
            }
        }
        return "/getBoardList";
    }

    //server에서 client로 이미지 전송
    //springboot에서 URL주소를 통해 이미지를 받음 InputStream을 통해 파일을 http프로토콜에 전달하여 클라이언트에 전송

    @GetMapping("/viewImage/{imgname}")
    public ResponseEntity<byte[]> viewImage(@PathVariable("imgname")String input_imgName) throws IOException {
        //RespnoseEntity : http프로토콜을 통해서 byte데이터를 전달하는 객체, byte(소문자=기본타입)
        //@PathVariable : URL주소의 값을 받아옴
        String path = "D:\\\\train\\\\Shoppingmall\\\\src\\\\main\\\\resources\\\\static\\\\upload\\\\" + input_imgName;

        //데이터(이미지)를 전송하기 위한 객체로써 java에서는 항상 데이터를 스트링타입으로 전달
        InputStream inputStream = new FileInputStream(path);
        //byte배열로 변환
        byte[] imgByteArr = toByteArray(inputStream);
        inputStream.close();
        //ResponseEntity를 통해 http프로토콜로 클라이언트에게 데이터 전송
        return new ResponseEntity<byte[]>(imgByteArr, HttpStatus.OK);
    }
}
