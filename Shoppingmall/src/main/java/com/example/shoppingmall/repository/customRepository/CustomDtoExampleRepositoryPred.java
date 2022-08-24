package com.example.shoppingmall.repository.customRepository;

import com.example.shoppingmall.entity.customDto.CustomDtoExample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomDtoExampleRepositoryPred extends JpaRepository<CustomDtoExample, String> {
}
