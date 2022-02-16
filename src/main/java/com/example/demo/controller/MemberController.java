package com.example.demo.controller;

import com.example.demo.domain.Board;
import com.example.demo.domain.Member;
import com.example.demo.service.BoardService;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MemberController {
    private final MemberService memberService;
    private final BoardService boardService;



    @Autowired
    public MemberController(MemberService memberService, BoardService boardService) {
        this.memberService = memberService;
        this.boardService = boardService;
    }


    @GetMapping(value = "/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping(value = "/members/new")
    public String create(MemberForm form) {
        System.out.println(form);
        System.out.println(form.getName());
        Member member = new Member();
        member.setName(form.getName());
        memberService.join(member);
        return "redirect:/board?id=" + member.getName();
    }

    @GetMapping(value = "/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }

    @GetMapping(value = "/members/list")
    public String boardlist(Model model) {
    List<Board> boards = boardService.findBoards();
        model.addAttribute("boards", boards);
        return "members/list";
    }


    @GetMapping(value = "/members/insertBoard")
    public String insertboard(Model model) {
       // List<Member> members = memberService.findMembers();
        //model.addAttribute("members", members);
        return "members/post";
    }

    @PostMapping(value = "/members/insertBoard")
    public String insert(BoardForm form) {
        Board board = new Board();
        board.setSeq(form.getSeq());
        board.setTitle(form.getTitle());
        board.setWriter(form.getWriter());
        board.setWriter(form.getWriter());
        boardService.new_post(board);
        return "redirect:/members/list";
    }


    @GetMapping(value = "getBoard")
    public String board(@RequestParam("seq") String name, Model model){   //로그인 정보를 넘겨야함
        model.addAttribute("seq", name);
        return "/members/post_view";
    }


}
