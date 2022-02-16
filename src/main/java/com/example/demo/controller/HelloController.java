package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("/")
    public String home(){
        return "home";
    }




    @GetMapping("board")
    public String board(@RequestParam("id") String name, Model model){   //로그인 정보를 넘겨야함
        model.addAttribute("id", name);
        return "board";
    }



}
