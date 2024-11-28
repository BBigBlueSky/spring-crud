package com.example.secondproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecondController {
    @GetMapping("/hi")//이거 적용할라면 의존성 주입에서 Spring web도 추가해야함.
    public String niceToMeetYou(Model model)
    {
        model.addAttribute("username","아리");

        return "greetings";
    }

    @GetMapping("/bye")
    public String seeYouNext(Model model){
        model.addAttribute("nickname","아리");
        return "goodbye";
    }
}
