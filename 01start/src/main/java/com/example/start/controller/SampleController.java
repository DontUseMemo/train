package com.example.start.controller;

import com.example.start.model.request.LoginDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class SampleController {

    @GetMapping("/01helloWorld")
    public String helloWorldGet1() {
        return "01helloWorld";
    }

    @RequestMapping(value = "/02loginInput", method = RequestMethod.GET)
    public String helloWorldGet2() {
        return "02loginInput";
    }

//    @RequestMapping(value = "/03loginOutput", method = RequestMethod.POST)
    @PostMapping("/03loginOutput")
    public String loginOut(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam String password,
            Model model) {
        System.out.println(name);
        System.out.println(password);
        model.addAttribute("name", name);
        model.addAttribute("password", password);
        return "03loginOutput";
    }

    @GetMapping("/04loginInput")
    public String loginDtoInput() {
        return "04loginInput";
    }

    @PostMapping("/05loginOutput")
    public String loginDtoOutput(LoginDto dto, Model model) {
        System.out.println(dto);
        model.addAttribute("dto", dto);
        return "05loginOutput";
    }

//    @PostMapping("/05loginOutput")
//    public ModelAndView loginDtoOutput(LoginDto dto) {
//        ModelAndView model = new ModelAndView();
//        System.out.println(dto);
//        model.addObject("dto", dto);
//        model.setViewName("/05loginOutput");
//        return model;
//    }

    @GetMapping("/06arrayList")
    public ModelAndView arrayList(){
        ArrayList<LoginDto> dtos = new ArrayList<>();
        dtos.add(new LoginDto("1","1"));
        dtos.add(new LoginDto("2","2"));
        dtos.add(new LoginDto("3","3"));
        ModelAndView model = new ModelAndView();
        model.addObject("dtos",dtos);
        model.setViewName("06Output");
        return model;
    }

    @GetMapping("/07main")
    public String getMain() {
        return "07main";
    }
}
