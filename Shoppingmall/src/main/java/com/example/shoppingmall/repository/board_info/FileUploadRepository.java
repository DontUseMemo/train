package com.example.shoppingmall.repository.board_info;

import com.example.shoppingmall.entity.dataSample.FileUploadEntity;
import org.springframework.data.repository.CrudRepository;

//파일 업로드 엔티티를 저장하는 인터페이스 (JPA CrudRepository 활용)
public interface FileUploadRepository extends CrudRepository<FileUploadEntity, Long> {

    //findBy : 튜플을 찾겠다
    //BaordSeq : BoardSeq 컬럼에 데이터를 찾겠다
    FileUploadEntity findByBoardSeq(Long boardSeq);
}
