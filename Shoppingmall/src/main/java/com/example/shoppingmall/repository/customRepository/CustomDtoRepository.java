package com.example.shoppingmall.repository.customRepository;

import com.example.shoppingmall.entity.customDto.CustomDtoExample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomDtoRepository extends JpaRepository<CustomDtoExample, String> {

    //nativeQuery :
    //1. Entity단위로 DB조회와 client데이터 전송을 동시에 할 경우 table 구조가 드러나기 때문에 보안적인 위험
    // >> DTO를 만들어서 데이터 전송에 쓰임
    //2. JPA Entity 단위로 데이터를 조회할 경우 자유도가 현격히 떨어지므로 일반 DTO를 만들어서 JOIN 등등 데이터 리턴값을 자유롭게 받을 수 있음
    //단, 단점으로 JPQL을 써서 데이터를 주고 받을 경우 객체 구조적인 -- 단단함, 유지보수에 용이
    //SQL보다는 jpql + dto를 쓰는게 가장 좋다고 생각 : 구조적인 견고함과 dto의 유연함을 동시에 취하고 상황에 따라 대처할 수 있는 유연성을 가짐
    @Query(value = "SELECT m.id AS input_id, b.writer AS input_writer, b.title AS  input_title " +
            "FROM Member m " +
            "inner join Baord b on m.id = b.writer " +
            "where m.id = :memberId",
            nativeQuery = true)
    CustomDtoExample findExample();
}
