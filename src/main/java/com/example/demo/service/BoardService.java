package com.example.demo.service;

import com.example.demo.domain.Board;
import com.example.demo.domain.Member;
import com.example.demo.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {


    private final BoardRepository boardRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public Long new_post(Board board) {
        //validateDuplicateMember(member); //중복 회원 검증
        boardRepository.save_board(board);
        return board.getSeq();
    }

    public List<Board> findBoards() {
        return boardRepository.findAll_board();
    }

}
