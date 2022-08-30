package com.example.shoppingmall.controller.testConstroller;

import com.example.shoppingmall.entity.customDto.CustomAPIDtoExample;
import com.example.shoppingmall.entity.customDto.CustomDtoExample;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    //CRUD restFullApi rest하게 API를 만들자 (암무적인 규칙)
    //Create, Read, Update, Delete
    //data를 전달하는 controller URI주소 만들기
    @ResponseBody
    @RequestMapping("/read/alldata")
    public CustomAPIDtoExample readAlldata() {
        CustomAPIDtoExample customAPIDtoExample = new CustomAPIDtoExample();

        customAPIDtoExample.setId("아이디");

        return customAPIDtoExample;
    }
}
